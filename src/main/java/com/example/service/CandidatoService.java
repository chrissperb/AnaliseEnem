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

    public List<Candidato> buscarPorEscola(String noMunicipioEsc) {
        if (noMunicipioEsc == null || noMunicipioEsc.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da Escola não pode ser vazio");
        }
        return candidatoRepository.findByNomeEscola(noMunicipioEsc);
    }
}
