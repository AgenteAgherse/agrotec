package com.example.agroltec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agroltec.Model.usuario;

public interface UserRepository extends JpaRepository<usuario, Integer>{
    
}
