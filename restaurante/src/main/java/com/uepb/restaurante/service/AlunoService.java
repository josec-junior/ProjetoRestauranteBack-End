package com.uepb.restaurante.service;

import com.uepb.restaurante.models.AlunoEntity;
import com.uepb.restaurante.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoEntity> findAll() {
        return alunoRepository.findAll();
    }

    public AlunoEntity findById(Integer id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public AlunoEntity save(AlunoEntity aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteById(Integer id) {
        alunoRepository.deleteById(id);
    }
}