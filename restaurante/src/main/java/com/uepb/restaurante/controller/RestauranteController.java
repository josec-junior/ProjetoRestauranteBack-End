package com.uepb.restaurante.controller;

import com.uepb.restaurante.models.RestauranteEntity;
import com.uepb.restaurante.service.RestauranteService;
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
        return restauranteService.save(restaurante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        restauranteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
