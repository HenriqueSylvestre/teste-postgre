package com.example.teste_postgre.infrastructure.repositories.models;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstruturaAtendimentoId implements Serializable {

    private String funcional;
    private UUID idConta;
}
