package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "dados_enem")
@Data // Getters e Setters são gerados automaticamente pelo Lombok (@Data)
public class Candidato {
    @Id
    private Long nuInscricao;

    private Integer nuAno;
    private Integer tpFaixaEtaria;
    private String tpSexo;
    private Integer tpEstadoCivil;
    private Integer tpCorRaca;
    private Integer tpNacionalidade;

    // Informações escolares
    private String noMunicipioEsc;
    private String sgUfEsc;
    private Integer tpEscola;

    // Notas das provas
    private BigDecimal nuNotaCn;
    private BigDecimal nuNotaCh;
    private BigDecimal nuNotaLc;
    private BigDecimal nuNotaMt;
    private Integer nuNotaRedacao;

    // Componentes da redação
    private Integer nuNotaComp1;
    private Integer nuNotaComp2;
    private Integer nuNotaComp3;
    private Integer nuNotaComp4;
    private Integer nuNotaComp5;

    // Status de presença
    private Integer tpPresencaCn;
    private Integer tpPresencaCh;
    private Integer tpPresencaLc;
    private Integer tpPresencaMt;

    // Local de prova
    private String noMunicipioProva;
    private String sgUfProva;

}
