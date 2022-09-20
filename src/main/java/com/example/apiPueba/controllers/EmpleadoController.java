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

import com.example.apiPueba.models.EmpleadoModel;
import com.example.apiPueba.services.EmpleadoServices;

@RestController
@RequestMapping("/Empleado")
public class EmpleadoController {
    
    @Autowired
    EmpleadoServices empleadoServices;

    @GetMapping()
    public ArrayList<EmpleadoModel> obtenerEmpleado(){
        return empleadoServices.obtenerEmpleado();
    }

    @PostMapping()
    public EmpleadoModel guardarEmpleado(@RequestBody EmpleadoModel emp){
        return this.empleadoServices.guardarEmpleado(emp);
    }

    @GetMapping(path = "/{id}")
    public Optional<EmpleadoModel> obtenerEmpledao(@PathVariable("id") Integer id){
        return this.empleadoServices.obtenerPorId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Integer id){
        boolean ok = this.empleadoServices.eliminarEmpleado(id);

        if (ok) {
            return "se elimino el empleado con id " + id;
        } else {
            return "No se encontro el empleado con id " + id;
        }
    }

    


}
