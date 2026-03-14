package com.br.desafiosctec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empreendimento")
public class Empreendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeEmpreendimento;
    private String nomeEmpreendedor;
    private String municipio;
    private String email;

    @Enumerated(EnumType.STRING)
    private Segmento segmento;

    @Enumerated(EnumType.STRING)
    private Status status;

}