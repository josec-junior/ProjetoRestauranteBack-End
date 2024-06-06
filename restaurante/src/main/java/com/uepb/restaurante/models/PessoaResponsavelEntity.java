package com.uepb.restaurante.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="pessoasResponsaveis")
public class PessoaResponsavelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 5, max = 255, message = "O tamanho do nome da pessoa responsavel deve ser entre {min} e {max}")
    private String nome;

    @NotNull
    @Size(min = 14, max = 14, message = "O CPF deve ter 14 caracteres")
    private String cpf;

    @NotNull
    @Size(min = 11, max = 11, message = "O número de telefone deve ter 11 dígitos")
    private String telefone_whatsapp;

    @NotNull
    @Size(min = 10, max = 255, message = "O e-mail deve ter entre {min} e {max} caracteres")
    private String email;
}