package com.example.agroltec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agroltec.Model.Factura;

public interface FacturasRepository extends JpaRepository<Factura, Integer>{
    
}
