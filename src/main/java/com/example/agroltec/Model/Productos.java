package com.example.agroltec.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class Productos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "precio")
    private Double price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "descripcion")
    private String description;
}
