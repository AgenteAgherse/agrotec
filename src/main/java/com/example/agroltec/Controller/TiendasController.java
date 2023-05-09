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

import com.example.agroltec.Model.tienda;
import com.example.agroltec.Repository.TiendasRepository;

@RestController
@RequestMapping("/tiendas")
public class TiendasController {
    @Autowired
    private TiendasRepository repository;
    

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<tienda> getAllUsers() {
        return repository.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addShop(@RequestBody tienda nueva) throws URISyntaxException {
        tienda creado = repository.save(nueva);
        return ResponseEntity.created(new URI("/tienda/" + creado.getId())).body(creado);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public tienda getShop(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateShop(@PathVariable Integer id, @RequestBody tienda tienda) {
        tienda updateShop = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.save(tienda);
        return ResponseEntity.ok(tienda);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteShop(@PathVariable Integer id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
   
}
