package com.uepb.restaurante.controller;

import com.uepb.restaurante.models.EnderecoEntity;
import com.uepb.restaurante.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoEntity> findAll() {
        return enderecoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoEntity> findById(@PathVariable Integer id) {
        EnderecoEntity endereco = enderecoService.findById(id);
        if (endereco == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(endereco);
    }

    @PostMapping
    public EnderecoEntity save(@RequestBody EnderecoEntity endereco) {
        return enderecoService.save(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
