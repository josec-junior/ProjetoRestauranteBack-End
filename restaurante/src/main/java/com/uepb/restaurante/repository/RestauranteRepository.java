package com.uepb.restaurante.repository;

import com.uepb.restaurante.models.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Integer> {}