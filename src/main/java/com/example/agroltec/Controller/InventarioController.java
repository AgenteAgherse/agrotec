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

import com.example.agroltec.Model.Inventarios;
import com.example.agroltec.Repository.InventarioRepository;

@RestController
@RequestMapping("/tiendas/inventario")
public class InventarioController {
    @Autowired
    private InventarioRepository repository;
    

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Inventarios> getAllRegisters() {
        return repository.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addRegister(@RequestBody Inventarios nueva) throws URISyntaxException {
        Inventarios inventario = repository.save(nueva);
        return ResponseEntity.created(new URI("/tiendas/inventario/" + inventario.getId())).body(inventario);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Inventarios get(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateInventory(@PathVariable Integer id, @RequestBody Inventarios inventaio) {
        Inventarios updateInventary = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.save(inventaio);
        return ResponseEntity.ok(inventaio);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteInventoryById(@PathVariable Integer id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
   
    
}
