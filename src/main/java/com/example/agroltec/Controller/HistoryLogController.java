package com.example.agroltec.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.agroltec.Model.HistorialIngreso;
import com.example.agroltec.Repository.HistorialIngresoRepository;

@RestController
@RequestMapping("/users/historyLog")
public class HistoryLogController {
    @Autowired
    private HistorialIngresoRepository repository;
    

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HistorialIngreso> getAllUsers() {
        return repository.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addLog(@RequestBody HistorialIngreso HistorialIngreso) throws URISyntaxException {
        HistorialIngreso creado = repository.save(HistorialIngreso);
        return ResponseEntity.created(new URI("/users/" + creado.getId())).body(creado);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HistorialIngreso getAllLogs(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

}
