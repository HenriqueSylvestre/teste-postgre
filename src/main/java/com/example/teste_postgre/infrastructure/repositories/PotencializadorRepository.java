package com.example.teste_postgre.infrastructure.repositories;

import com.example.teste_postgre.infrastructure.repositories.models.Potencializador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PotencializadorRepository extends JpaRepository<Potencializador, UUID> {
}
