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

import com.example.apiPueba.models.RolModel;
import com.example.apiPueba.services.RolServices;

@RestController
@RequestMapping("/rol")
public class RolController {
    
    @Autowired
    RolServices RolServices;

    @GetMapping()
    public ArrayList<RolModel> obtenerRol(){
        return RolServices.obtenerRols();
    }

    @PostMapping()
    public RolModel guardarRol(@RequestBody RolModel rol){
        return this.RolServices.guardarRol(rol);
    }

    @GetMapping(path = "/{id}")
    public Optional<RolModel> obtenerRol(@PathVariable("id") Integer id){
        return this.RolServices.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok = this.RolServices.eliminarRol(id);

        if (ok) {
            return "se elimino el rol con id " + id;
        } else {
            return "No se encontro el rol con id " + id;
        }
    }

    


}
