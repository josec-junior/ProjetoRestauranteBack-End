package com.uepb.restaurante.service;

import com.uepb.restaurante.models.RestauranteEntity;
import com.uepb.restaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<RestauranteEntity> findAll() {
        return restauranteRepository.findAll();
    }

    public RestauranteEntity findById(Integer id) {
        return restauranteRepository.findById(id).orElse(null);
    }

    public RestauranteEntity save(RestauranteEntity restaurante) {
        return restauranteRepository.save(restaurante);
    }

    public void deleteById(Integer id) {
        restauranteRepository.deleteById(id);
    }
}