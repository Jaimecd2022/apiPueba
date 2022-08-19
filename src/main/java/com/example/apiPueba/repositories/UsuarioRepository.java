package com.example.apiPueba.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.apiPueba.models.UsuarioModels;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModels,Long> {
 
    //Metodo para consultar usuario por prioridad en la bd
    //tambien se puede consultar por email o nombre
    public abstract ArrayList<UsuarioModels> findByPrioridad(Integer prioridad);
}
