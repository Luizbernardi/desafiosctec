package com.br.desafiosctec.service.impl;

import com.br.desafiosctec.dto.EmpreendimentoRequestDTO;
import com.br.desafiosctec.dto.EmpreendimentoResponseDTO;
import com.br.desafiosctec.exception.ResourceNotFoundException;
import com.br.desafiosctec.mapper.EmpreendimentoMapper;
import com.br.desafiosctec.model.Empreendimento;
import com.br.desafiosctec.repository.EmpreendimentoRepository;
import com.br.desafiosctec.service.EmpreendimentoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpreendimentoServiceImpl implements EmpreendimentoService {

    private final String NAO_ENCONTRADO = "Empreendimento não encontrado";

    private final EmpreendimentoRepository repository;

    public EmpreendimentoServiceImpl(EmpreendimentoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmpreendimentoResponseDTO criar(EmpreendimentoRequestDTO dto) {

        Empreendimento emp = EmpreendimentoMapper.toEntity(dto);

        emp = repository.save(emp);

        return EmpreendimentoMapper.toDTO(emp);
    }

    @Override
    public List<EmpreendimentoResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(EmpreendimentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmpreendimentoResponseDTO buscarPorId(Long id) {

        Empreendimento emp = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NAO_ENCONTRADO));

        return EmpreendimentoMapper.toDTO(emp);
    }

    @Override
    public EmpreendimentoResponseDTO atualizar(Long id, EmpreendimentoRequestDTO dto) {

        Empreendimento emp = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NAO_ENCONTRADO));

        emp.setNomeEmpreendimento(dto.getNomeEmpreendimento());
        emp.setNomeEmpreendedor(dto.getNomeEmpreendedor());
        emp.setMunicipio(dto.getMunicipio());
        emp.setEmail(dto.getEmail());
        emp.setSegmento(dto.getSegmento());
        emp.setStatus(dto.getStatus());

        emp = repository.save(emp);

        return EmpreendimentoMapper.toDTO(emp);
    }

    @Override
    public void deletar(Long id) {

        Empreendimento emp = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NAO_ENCONTRADO));

        repository.delete(emp);
    }

}