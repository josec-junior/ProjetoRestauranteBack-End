package com.uepb.restaurante.controller;

import com.uepb.restaurante.models.PessoaResponsavelEntity;
import com.uepb.restaurante.service.PessoaResponsavelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoasResponsaveis")
public class PessoaResponsavelController {

    @Autowired
    private PessoaResponsavelService pessoaResponsavelService;

    @GetMapping
    public List<PessoaResponsavelEntity> findAll() {
        return pessoaResponsavelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponsavelEntity> findById(@PathVariable Integer id) {
        PessoaResponsavelEntity pessoaResponsavel = pessoaResponsavelService.findById(id);
        if (pessoaResponsavel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pessoaResponsavel);
    }

    @PostMapping
    public PessoaResponsavelEntity save(@RequestBody PessoaResponsavelEntity pessoaResponsavel) {
        return pessoaResponsavelService.save(pessoaResponsavel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        pessoaResponsavelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
