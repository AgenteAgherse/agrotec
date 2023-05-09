package com.example.agroltec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agroltec.Model.Inventarios;

public interface InventarioRepository extends JpaRepository<Inventarios, Integer>{
    
}
