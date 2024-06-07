package com.uepb.restaurante.controller;

import com.uepb.restaurante.models.AlunoEntity;
import com.uepb.restaurante.service.AlunoService;
import com.uepb.restaurante.models.EnderecoEntity;
import com.uepb.restaurante.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private EnderecoService enderecoService;

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
        EnderecoEntity endereco = enderecoService.findById(aluno.getEndereco().getId());
        if (endereco == null) {
            throw new RuntimeException("Endereço não encontrado com o ID: " + aluno.getEndereco().getId());
        }
    
        aluno.setEndereco(endereco);
        return alunoService.save(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        alunoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
