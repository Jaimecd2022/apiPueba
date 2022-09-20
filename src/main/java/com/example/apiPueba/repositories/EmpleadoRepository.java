package com.example.apiPueba.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.apiPueba.models.EmpleadoModel;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadoModel,Integer> {
 
    //Metodo para consultar usuario por prioridad en la bd
    //tambien se puede consultar por email o nombre

}
