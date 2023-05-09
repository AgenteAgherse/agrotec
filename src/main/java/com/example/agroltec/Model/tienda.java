package com.example.agroltec.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tiendas")
@Data
public class tienda {
    
    @Id
    @Column(name = "idtiendas")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ciudad", length = 100)
    private String city;

    @Column(name = "codigopostal")
    private Integer postalCode;

    @Column(name = "nombre", length = 200)
    private String nombre;

    @Column(name = "direccion")
    private String address;

}
