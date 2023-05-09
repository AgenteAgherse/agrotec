package com.example.agroltec.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.agroltec.Model.Factura;
import com.example.agroltec.Repository.FacturasRepository;

@Controller
@RequestMapping("/facturas")
public class FacturasController {
    @Autowired
    private FacturasRepository repository;
    

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Factura> getAllBills() {
        return repository.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addBill(@RequestBody Factura nueva) throws URISyntaxException {
        Factura factura = repository.save(nueva);
        return ResponseEntity.created(new URI("/factura/" + factura.getId())).body(factura);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Factura getBill(@PathVariable Integer id) {
        return repository.findById(id).get();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateBill(@PathVariable Integer id, @RequestBody Factura Factura) {
        Factura updateBill = repository.findById(id).orElseThrow(RuntimeException::new);
        repository.save(Factura);
        return ResponseEntity.ok(Factura);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteBill(@PathVariable Integer id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
   
}
