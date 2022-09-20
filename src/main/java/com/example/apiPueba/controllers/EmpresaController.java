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

import com.example.apiPueba.models.EmpresaModel;
import com.example.apiPueba.services.EmpresaServices;

@RestController
@RequestMapping("/Empresa")
public class EmpresaController {
    
    @Autowired
    EmpresaServices empresaServices;

    @GetMapping()
    public ArrayList<EmpresaModel> obtenerEmpresa(){
        return empresaServices.obtenerEmpresa();
    }

    @PostMapping()
    public EmpresaModel guardarEmpresa(@RequestBody EmpresaModel emp){
        return this.empresaServices.guardarEmpresa(emp);
    }

    @GetMapping(path = "/{id}")
    public Optional<EmpresaModel> obtenerEmpresa(@PathVariable("id") Integer id){
        return this.empresaServices.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok = this.empresaServices.eliminarEmpresa(id);

        if (ok) {
            return "se elimino la Empresa con id " + id;
        } else {
            return "No se encontro la Empresa con id " + id;
        }
    }

    


}
