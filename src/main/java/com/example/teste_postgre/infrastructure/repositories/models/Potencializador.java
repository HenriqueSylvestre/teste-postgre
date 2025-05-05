package com.example.teste_postgre.infrastructure.repositories.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Potencializador {

    @Id
    private UUID idConta;

    private UUID cliente;
    private String codigoBanco;
    private String tipoEmpresa;
    private String agencia;
    private String conta;
    private String digito;

    private BigDecimal variavel1;
    private Integer rankingVariavel1;

    private BigDecimal variavel2;
    private Integer rankingVariavel2;

    private BigDecimal variavel3;
    private Integer rankingVariavel3;

    private BigDecimal variavel4;
    private Integer rankingVariavel4;

    private BigDecimal variavel5;
    private Integer rankingVariavel5;

    private BigDecimal variavel6;
    private Integer rankingVariavel6;

    private BigDecimal variavel7;
    private Integer rankingVariavel7;

    private BigDecimal variavel8;
    private Integer rankingVariavel8;

    private BigDecimal variavel9;
    private Integer rankingVariavel9;

    private BigDecimal variavel10;
    private Integer rankingVariavel10;

    private BigDecimal variavel11;
    private Integer rankingVariavel11;

    private BigDecimal variavel12;
    private Integer rankingVariavel12;

    private BigDecimal variavel13;
    private Integer rankingVariavel13;

    private BigDecimal variavel14;
    private Integer rankingVariavel14;

    private BigDecimal variavel15;
    private Integer rankingVariavel15;
}
