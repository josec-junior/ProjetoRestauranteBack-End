package com.uepb.restaurante.controller;

import com.uepb.restaurante.models.AlunoEntity;
import com.uepb.restaurante.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoEntity> findAll() {
        return alunoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoEntity> findById(@PathVariable Integer id) {
        AlunoEntity aluno = alunoService.findById(id);
        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public AlunoEntity save(@RequestBody AlunoEntity aluno) {
        return alunoService.save(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        alunoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
