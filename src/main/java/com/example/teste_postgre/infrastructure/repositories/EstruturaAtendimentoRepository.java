package com.example.teste_postgre.infrastructure.repositories;

import com.example.teste_postgre.infrastructure.repositories.models.EstruturaAtendimento;
import com.example.teste_postgre.infrastructure.repositories.models.EstruturaAtendimentoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstruturaAtendimentoRepository extends JpaRepository<EstruturaAtendimento, EstruturaAtendimentoId> {
}
