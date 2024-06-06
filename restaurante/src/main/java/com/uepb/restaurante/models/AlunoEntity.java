package com.uepb.restaurante.models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="alunos")
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Size(min = 5, max = 255, message = "O tamanho do nome do aluno deve ser entre {min} e {max}")
    private String nome;

    @NotNull
    private Integer matricula;

    @NotNull
    @Size(min = 14, max = 14, message = "O CPF deve ter 14 caracteres")
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    @NotNull
    @Size(min = 5, max = 255, message = "O tamanho do nome do curso deve ser entre {min} e {max}")
    private String curso;
}