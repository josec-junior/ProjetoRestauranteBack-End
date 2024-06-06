package com.uepb.restaurante.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="enderecos")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 30, max = 255, message = "O tamanho do nome da rua deve ser entre {min} e {max}")
    private String rua;

    @NotNull
    private Integer numero;

    @NotNull
    @Size(min = 14, max = 14, message = "O tamanho do CEP deve ser 14 caraceteres (8 algarismos separados por um -)")
    private String cep;

    @NotNull
    @Size(min = 3, max = 50, message = "O tamanho do nome da cidade deve ser entre {min} e {max}")
    private String cidade;

    @NotNull
    @Size(min = 5, max = 50, message = "O tamanho do nome do estado deve ser entre {min} e {max}")
    private String estado;

    @NotNull
    @Size(min = 5, max = 50, message = "O tamanho do nome do país deve ser entre {min} e {max}")
    private String pais;
}
