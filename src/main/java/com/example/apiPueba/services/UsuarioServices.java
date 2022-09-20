package com.example.apiPueba.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiPueba.models.UsuarioModel;
import com.example.apiPueba.repositories.UsuarioRepository;

@Service
public class UsuarioServices {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }


    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    // se coloca de tipo optional ya que pueda que no exita ningun registro con ese ID
    public java.util.Optional<UsuarioModel> obtenerPorId(Integer id){
        return usuarioRepository.findById(id);
    }

    public boolean eliminarUsuario(Integer id){
        try {
            usuarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }



}
