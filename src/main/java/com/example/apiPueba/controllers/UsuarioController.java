package com.example.apiPueba.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiPueba.models.UsuarioModels;
import com.example.apiPueba.services.UsuarioServices;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping()
    public ArrayList<UsuarioModels> obtenerUsusarios(){
        return usuarioServices.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModels guardarUsuarios(@RequestBody UsuarioModels usuario){
        return this.usuarioServices.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModels> obtenerUsusarios(@PathVariable("id") Long id){
        return this.usuarioServices.obtenerPorId(id);
    }

    @GetMapping("/query")
    public ArrayList<UsuarioModels> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioServices.obtenerPorPrioridad(prioridad);
        
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioServices.eliminarUsuario(id);

        if (ok) {
            return "se elimino el usuario con id " + id;
        } else {
            return "No se encontro el usuario con id " + id;
        }
    }

    


}
