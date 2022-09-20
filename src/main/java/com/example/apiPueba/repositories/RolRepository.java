package com.example.apiPueba.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.apiPueba.models.RolModel;

@Repository
public interface RolRepository extends CrudRepository<RolModel,Integer> {
 
    //Metodo para consultar usuario por prioridad en la bd
    //tambien se puede consultar por email o nombre
    
    //public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
}
