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
import org.springframework.web.bind.annotation.RestController;

import com.example.apiPueba.models.UsuarioModel;
import com.example.apiPueba.services.UsuarioServices;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    
    @Autowired
    UsuarioServices usuarioServices;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsusarios(){
        return usuarioServices.obtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuarios(@RequestBody UsuarioModel usuario){
        return this.usuarioServices.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsusarios(@PathVariable("id") Integer id){
        return this.usuarioServices.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok = this.usuarioServices.eliminarUsuario(id);

        if (ok) {
            return "se elimino el usuario con id " + id;
        } else {
            return "No se encontro el usuario con id " + id;
        }
    }

    


}
