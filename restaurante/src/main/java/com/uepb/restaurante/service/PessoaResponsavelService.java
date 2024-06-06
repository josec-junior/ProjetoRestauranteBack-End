package com.uepb.restaurante.service;

import com.uepb.restaurante.models.PessoaResponsavelEntity;
import com.uepb.restaurante.repository.PessoaResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaResponsavelService {
    @Autowired
    private PessoaResponsavelRepository pessoaResponsavelRepository;

    public List<PessoaResponsavelEntity> findAll() {
        return pessoaResponsavelRepository.findAll();
    }

    public PessoaResponsavelEntity findById(Integer id) {
        return pessoaResponsavelRepository.findById(id).orElse(null);
    }

    public PessoaResponsavelEntity save(PessoaResponsavelEntity pessoaResponsavel) {
        return pessoaResponsavelRepository.save(pessoaResponsavel);
    }

    public void deleteById(Integer id) {
        pessoaResponsavelRepository.deleteById(id);
    }
}