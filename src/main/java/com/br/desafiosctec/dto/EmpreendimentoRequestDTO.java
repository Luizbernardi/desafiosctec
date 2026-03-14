package com.br.desafiosctec.dto;

import com.br.desafiosctec.model.Segmento;
import com.br.desafiosctec.model.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmpreendimentoRequestDTO {

    @NotBlank
    private String nomeEmpreendimento;

    @NotBlank
    private String nomeEmpreendedor;

    @NotBlank
    private String municipio;

    @Email
    @NotBlank
    private String email;

    @NotNull
    private Segmento segmento;

    @NotNull
    private Status status;

}