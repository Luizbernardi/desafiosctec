package com.br.desafiosctec.dto;

import com.br.desafiosctec.model.Segmento;
import com.br.desafiosctec.model.Status;
import lombok.Data;

@Data
public class EmpreendimentoResponseDTO {

    private Long id;
    private String nomeEmpreendimento;
    private String nomeEmpreendedor;
    private String municipio;
    private String email;
    private Segmento segmento;
    private Status status;

}