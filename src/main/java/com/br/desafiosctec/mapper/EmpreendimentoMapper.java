package com.br.desafiosctec.mapper;

import com.br.desafiosctec.dto.EmpreendimentoRequestDTO;
import com.br.desafiosctec.dto.EmpreendimentoResponseDTO;
import com.br.desafiosctec.model.Empreendimento;

public class EmpreendimentoMapper {

    public static Empreendimento toEntity(EmpreendimentoRequestDTO dto) {

        Empreendimento emp = new Empreendimento();

        emp.setNomeEmpreendimento(dto.getNomeEmpreendimento());
        emp.setNomeEmpreendedor(dto.getNomeEmpreendedor());
        emp.setMunicipio(dto.getMunicipio());
        emp.setEmail(dto.getEmail());
        emp.setSegmento(dto.getSegmento());
        emp.setStatus(dto.getStatus());

        return emp;
    }

    public static EmpreendimentoResponseDTO toDTO(Empreendimento entity) {

        EmpreendimentoResponseDTO dto = new EmpreendimentoResponseDTO();

        dto.setId(entity.getId());
        dto.setNomeEmpreendimento(entity.getNomeEmpreendimento());
        dto.setNomeEmpreendedor(entity.getNomeEmpreendedor());
        dto.setMunicipio(entity.getMunicipio());
        dto.setEmail(entity.getEmail());
        dto.setSegmento(entity.getSegmento());
        dto.setStatus(entity.getStatus());

        return dto;
    }

}