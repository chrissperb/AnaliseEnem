package com.example.service;

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

}
