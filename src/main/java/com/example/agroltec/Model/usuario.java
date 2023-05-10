package com.example.agroltec.Model;

import java.util.List;

import com.example.agroltec.Model.tienda;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class usuario {
    

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Integer id;

    @Column(name = "nombre", length = 70)
    private String nombre;

    @Column(name = "apellido", length = 200)
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contraseña")
    private String password;

    @Column(name = "rol")
    private String rol;

    @Column(name = "correo", length = 150)
    private String correo;
    
    @Column(name = "identificacion")
    private Integer identificacion;

}
