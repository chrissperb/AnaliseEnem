package com.example.repository;

import com.example.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    // Métodos básicos de CRUD já vêm implementados

    // Busca case-insensitive e com match parcial
    List<Candidato> findByNoMunicipioEsc(String noMunicipioEsc);

    // Busca por município e tipo de escola
    List<Candidato> findByNoMunicipioEscAndTpEscola(String noMunicipioEsc, Integer tpEscola);

    // Média das notas por município e tipo de escola
    @Query("SELECT " +
            "AVG(c.nuNotaCn) as mediaCn, " +
            "AVG(c.nuNotaCh) as mediaCh, " +
            "AVG(c.nuNotaLc) as mediaLc, " +
            "AVG(c.nuNotaMt) as mediaMt, " +
            "AVG(c.nuNotaRedacao) as mediaRedacao " +
            "FROM Candidato c " +
            "WHERE c.noMunicipioEsc = :noMunicipioEsc AND c.tpEscola = :tpEscola")
    List<Object[]> calcularMediaPorCidadeETipoEscola(@Param("noMunicipioEsc") String noMunicipioEsc, @Param("tpEscola") Integer tpEscola);

}