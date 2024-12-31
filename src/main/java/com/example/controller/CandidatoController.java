package com.example.controller;

import com.example.model.Candidato;
import com.example.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping("/escola")
    public ResponseEntity<List<Candidato>> buscarPorEscola(
            @RequestParam String noMunicipioEsc) {
        List<Candidato> candidatos = candidatoService.buscarPorEscola(noMunicipioEsc);
        return ResponseEntity.ok(candidatos);
    }
}