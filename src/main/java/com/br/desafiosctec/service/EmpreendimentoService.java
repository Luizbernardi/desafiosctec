package com.br.desafiosctec.service;

import com.br.desafiosctec.dto.EmpreendimentoRequestDTO;
import com.br.desafiosctec.dto.EmpreendimentoResponseDTO;
import java.util.List;

public interface EmpreendimentoService {

    EmpreendimentoResponseDTO criar(EmpreendimentoRequestDTO dto);

    List<EmpreendimentoResponseDTO> listarTodos();

    EmpreendimentoResponseDTO buscarPorId(Long id);

    EmpreendimentoResponseDTO atualizar(Long id, EmpreendimentoRequestDTO dto);

    void deletar(Long id);

}