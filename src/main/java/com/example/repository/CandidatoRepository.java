package com.example.repository;

import com.example.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    // Métodos básicos de CRUD já vêm implementados

    // Busca case-insensitive e com match parcial
    List<Candidato> findByNomeEscola(String noMunicipioEsc);
}