package com.uepb.restaurante.repository;

import com.uepb.restaurante.models.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Integer> {}