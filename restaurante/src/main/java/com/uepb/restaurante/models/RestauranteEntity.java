package com.uepb.restaurante.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="restaurantes")
public class RestauranteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 5, max = 255, message = "O tamanho do nome do restaurante deve ser entre {min} e {max}")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;

    @OneToOne
    @JoinColumn(name = "pessoa_responsavel_id")
    private PessoaResponsavelEntity pessoaResponsavel;

    @NotNull
    private Integer capacidadeRefeicoes;

    @NotNull
    @Size(min = 5, max = 5, message = "O horário deve ser no formato 00:00 (24h)")
    private String horarioCafeManha;

    @NotNull
    @Size(min = 5, max = 5, message = "O horário deve ser no formato 00:00 (24h)")
    private String horarioAlmoco;

    @NotNull
    @Size(min = 5, max = 5, message = "O horário deve ser no formato 00:00 (24h)")
    private String horarioJantar;

    @NotNull
    @Size(min = 6, max = 255, message = "Deve ser informado pelo menos um dia de funcionamento")
    private String diasFuncionamento;
}