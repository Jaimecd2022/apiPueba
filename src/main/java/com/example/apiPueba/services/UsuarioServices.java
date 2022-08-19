package com.example.apiPueba.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiPueba.models.UsuarioModels;
import com.example.apiPueba.repositories.UsuarioRepository;

@Service
public class UsuarioServices {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModels> obtenerUsuarios(){
        return (ArrayList<UsuarioModels>) usuarioRepository.findAll();
    }


    public UsuarioModels guardarUsuario(UsuarioModels usuario){
        return usuarioRepository.save(usuario);
    }

    // se coloca de tipo optional ya que pueda que no exita ningun registro con ese ID
    public java.util.Optional<UsuarioModels> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModels> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario(Long id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }



}
