package com.example.apiPueba.models;

import javax.persistence.*;

@Entity
@Table(name = "movimientodinero")
public class MovimientoDineroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Integer id;

    private double monto;
    private String concepto;

    //relacion una a muchos con la tabla empresa
    @ManyToOne
    @JoinColumn(name="empleado_id",referencedColumnName="id", insertable=false, updatable=false)
    private EmpleadoModel empleado_id;

    
    //Constructor
    public MovimientoDineroModel(Integer id,double monto, String concepto, EmpleadoModel empleado_id) {
        this.id = id;
        this.monto = monto;
        this.concepto = concepto;
        this.empleado_id = empleado_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    

}

