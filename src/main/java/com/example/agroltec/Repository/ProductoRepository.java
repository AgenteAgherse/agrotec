package com.example.agroltec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agroltec.Model.Productos;

public interface ProductoRepository extends JpaRepository<Productos, Integer>{
    
}
