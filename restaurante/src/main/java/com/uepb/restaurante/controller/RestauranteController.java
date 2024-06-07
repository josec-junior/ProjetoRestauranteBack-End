package com.uepb.restaurante.controller;

import com.uepb.restaurante.models.RestauranteEntity;
import com.uepb.restaurante.service.RestauranteService;
import com.uepb.restaurante.models.EnderecoEntity;
import com.uepb.restaurante.service.EnderecoService;
import com.uepb.restaurante.models.PessoaResponsavelEntity;
import com.uepb.restaurante.service.PessoaResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private PessoaResponsavelService pessoaResponsavelService;

    @GetMapping
    public List<RestauranteEntity> findAll() {
        return restauranteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteEntity> findById(@PathVariable Integer id) {
        RestauranteEntity restaurante = restauranteService.findById(id);
        if (restaurante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurante);
    }

    @PostMapping
    public RestauranteEntity save(@RequestBody RestauranteEntity restaurante) {
        EnderecoEntity endereco = enderecoService.findById(restaurante.getEndereco().getId());
        PessoaResponsavelEntity pessoaResponsavel = pessoaResponsavelService.findById(restaurante.getPessoaResponsavel().getId());
        if (endereco == null) {
            throw new RuntimeException("Endereço não encontrado com o ID: " + restaurante.getEndereco().getId());
        }

         if (pessoaResponsavel == null) {
            throw new RuntimeException("Endereço não encontrado com o ID: " + restaurante.getPessoaResponsavel().getId());
        }
    
        restaurante.setEndereco(endereco);
        restaurante.setPessoaResponsavel(pessoaResponsavel);
        return restauranteService.save(restaurante);
    }





    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        restauranteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
