package com.example.agroltec.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.agroltec.Model.usuario;
import com.example.agroltec.Repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:8081")
public class UserController {
    @Autowired
    private UserRepository repository;
    

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<usuario> getAllUsers() {
        return repository.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody usuario usuario) throws URISyntaxException {
        usuario creado = repository.save(usuario);
        return ResponseEntity.created(new URI("/users/" + creado.getId())).body(creado);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public usuario getUsuario(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody usuario usuario) {
        usuario updateUser = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
