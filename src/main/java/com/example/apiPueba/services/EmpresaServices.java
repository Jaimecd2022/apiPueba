package com.example.apiPueba.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apiPueba.models.EmpresaModel;
import com.example.apiPueba.models.EmpresaModel;
import com.example.apiPueba.repositories.EmpresaRepository;

@Service
public class EmpresaServices {
    
    @Autowired
    EmpresaRepository empresaRepository;

    public ArrayList<EmpresaModel> obtenerEmpresa(){
        return (ArrayList<EmpresaModel>) empresaRepository.findAll();
    }


    public EmpresaModel guardarEmpresa(EmpresaModel Rol){
        return empresaRepository.save(Rol);
    }

    // se coloca de tipo optional ya que pueda que no exita ningun registro con ese ID
    public java.util.Optional<EmpresaModel> obtenerPorId(Integer id){
        return empresaRepository.findById(id);
    }

    public boolean eliminarEmpresa(Integer id){
        try {
            empresaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }



}
