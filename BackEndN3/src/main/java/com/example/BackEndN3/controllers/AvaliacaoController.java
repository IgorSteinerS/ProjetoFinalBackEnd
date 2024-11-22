package com.example.BackEndN3.controllers;

import com.example.BackEndN3.dtos.AvaliacaoRequestDto;
import com.example.BackEndN3.dtos.AvaliacaoResponseDto;
import com.example.BackEndN3.services.AvaliacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<AvaliacaoResponseDto>> listarTodas() {
        List<AvaliacaoResponseDto> avaliacoes = avaliacaoService.listarTodas();
        return ResponseEntity.ok(avaliacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoResponseDto> buscarPorId(@PathVariable UUID id) {
        AvaliacaoResponseDto avaliacao = avaliacaoService.buscarPorId(id);
        return ResponseEntity.ok(avaliacao);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoResponseDto> criar(@Valid @RequestBody AvaliacaoRequestDto dto) {
        AvaliacaoResponseDto novaAvaliacao = avaliacaoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAvaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoResponseDto> atualizar(
            @PathVariable UUID id,
            @Valid @RequestBody AvaliacaoRequestDto dto) {
        AvaliacaoResponseDto atualizada = avaliacaoService.atualizar(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        avaliacaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
