package com.example.agroltec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agroltec.Model.tienda;

public interface TiendasRepository extends JpaRepository<tienda, Integer>{
    
}
