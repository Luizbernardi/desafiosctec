package com.br.desafiosctec.controller;

import com.br.desafiosctec.dto.EmpreendimentoRequestDTO;
import com.br.desafiosctec.dto.EmpreendimentoResponseDTO;
import com.br.desafiosctec.service.EmpreendimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/empreendimentos")
@RequiredArgsConstructor
public class EmpreendimentoController {

    private final EmpreendimentoService service;

    @PostMapping
    public ResponseEntity<EmpreendimentoResponseDTO> create(@RequestBody @Valid EmpreendimentoRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @GetMapping
    public ResponseEntity<List<EmpreendimentoResponseDTO>> findAll() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpreendimentoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpreendimentoResponseDTO> update(@PathVariable Long id, @RequestBody @Valid EmpreendimentoRequestDTO request) {
        return ResponseEntity.ok(service.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}