package com.example.teste_postgre.infrastructure.repositories.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@IdClass(EstruturaAtendimentoId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstruturaAtendimento {

    public EstruturaAtendimento(String funcional, UUID idConta) {
        this.funcional = funcional;
        this.idConta = idConta;
    }

    @Id
    private String funcional;

    @Id
    private UUID idConta;

    private String carteira;
    private String segmento;
}
