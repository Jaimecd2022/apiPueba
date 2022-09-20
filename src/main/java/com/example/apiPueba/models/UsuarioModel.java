package com.example.apiPueba.models;

import javax.persistence.*;
import javax.persistence.Id;
@Entity
@Table(name="usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer id;
    private String usuario; 
    private String contraseña;
    
    //relacion una a muchos con la tabla UsuarioModel
    @ManyToOne
    @JoinColumn(name="empleado_id",referencedColumnName="id", insertable=false, updatable=false)
    private EmpleadoModel empleado_id;

    //Constructor
    public UsuarioModel(Integer id, String usuario, String contraseña, EmpleadoModel empleado_id) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.empleado_id = empleado_id;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public EmpleadoModel getEmpleado_id() {
        return empleado_id;
    }
    public void setEmpleado_id(EmpleadoModel empleado_id) {
        this.empleado_id = empleado_id;
    }

   
    
}
