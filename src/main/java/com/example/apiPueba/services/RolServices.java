package com.example.apiPueba.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiPueba.models.RolModel;
import com.example.apiPueba.repositories.RolRepository;

@Service
public class RolServices {
    
    @Autowired
    RolRepository RolRepository;

    public ArrayList<RolModel> obtenerRols(){
        return (ArrayList<RolModel>) RolRepository.findAll();
    }


    public RolModel guardarRol(RolModel Rol){
        return RolRepository.save(Rol);
    }

    // se coloca de tipo optional ya que pueda que no exita ningun registro con ese ID
    public java.util.Optional<RolModel> obtenerPorId(Integer id){
        return RolRepository.findById(id);
    }

    public boolean eliminarRol(Integer id){
        try {
            RolRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }



}
