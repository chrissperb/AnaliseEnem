package com.example.service;

import com.example.dto.MediaNotasDTO;
import com.example.model.Candidato;
import com.example.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public List<Candidato> buscarPorMunicipio(String noMunicipioEsc) {
        if (noMunicipioEsc == null || noMunicipioEsc.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da Escola não pode ser vazio");
        }
        return candidatoRepository.findByNoMunicipioEsc(noMunicipioEsc);
    }

    public List<Candidato> buscarPorCidadeETipoEscola(String noMunicipioEsc, Integer tpEscola) {
        if (noMunicipioEsc == null || noMunicipioEsc.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do município não pode ser vazio");
        }
        if (tpEscola == null) {
            throw new IllegalArgumentException("O tipo de escola não pode ser nulo");
        }
        return candidatoRepository.findByNoMunicipioEscAndTpEscola(noMunicipioEsc, tpEscola);
    }

    public MediaNotasDTO calcularMediaPorCidadeETipoEscola(String noMunicipioEsc, Integer tpEscola) {
        if (noMunicipioEsc == null || noMunicipioEsc.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do município não pode ser vazio");
        }
        if (tpEscola == null) {
            throw new IllegalArgumentException("O tipo de escola não pode ser nulo");
        }

        List<Object[]> resultados = candidatoRepository.calcularMediaPorCidadeETipoEscola(noMunicipioEsc, tpEscola);
        if (resultados.isEmpty()) {
            return new MediaNotasDTO(0.0, 0.0, 0.0, 0.0, 0.0);
        }

        Object[] media = resultados.get(0);
        return new MediaNotasDTO(
                media[0] != null ? ((Number) media[0]).doubleValue() : 0.0,
                media[1] != null ? ((Number) media[1]).doubleValue() : 0.0,
                media[2] != null ? ((Number) media[2]).doubleValue() : 0.0,
                media[3] != null ? ((Number) media[3]).doubleValue() : 0.0,
                media[4] != null ? ((Number) media[4]).doubleValue() : 0.0
        );
    }

}
