package com.uepb.restaurante.service;

import com.uepb.restaurante.models.EnderecoEntity;
import com.uepb.restaurante.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<EnderecoEntity> findAll() {
        return enderecoRepository.findAll();
    }

    public EnderecoEntity findById(Integer id) {
        return enderecoRepository.findById(id).orElse(null);
    }

    public EnderecoEntity save(EnderecoEntity endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deleteById(Integer id) {
        enderecoRepository.deleteById(id);
    }
}