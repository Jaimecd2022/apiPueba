package com.example.apiPueba.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.apiPueba.models.EmpleadoModel;
import com.example.apiPueba.repositories.EmpleadoRepository;

@Service
public class EmpleadoServices {
    
    @Autowired
    EmpleadoRepository empleadoRepository;

    public ArrayList<EmpleadoModel> obtenerEmpleado(){
        return (ArrayList<EmpleadoModel>) empleadoRepository.findAll();
    }


    public EmpleadoModel guardarEmpleado(EmpleadoModel empleado){
        return empleadoRepository.save(empleado);
    }

    // se coloca de tipo optional ya que pueda que no exita ningun registro con ese ID
    public java.util.Optional<EmpleadoModel> obtenerPorId(Integer id){
        return empleadoRepository.findById(id);
    }

    public boolean eliminarEmpleado(Integer id){
        try {
            empleadoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }



}
