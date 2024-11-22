package com.example.BackEndN3.controllers;


import com.example.BackEndN3.dtos.ProfessorRequestDto;
import com.example.BackEndN3.dtos.ProfessorResponseDto;
import com.example.BackEndN3.services.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> listarTodos() {
        List<ProfessorResponseDto> professores = professorService.listarTodos();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> buscarPorId(@PathVariable UUID id) {
        ProfessorResponseDto professor = professorService.buscarPorId(id);
        return ResponseEntity.ok(professor);
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> criar(@Valid @RequestBody ProfessorRequestDto dto) {
        ProfessorResponseDto novoProfessor = professorService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> atualizar(
            @PathVariable UUID id,
            @Valid @RequestBody ProfessorRequestDto dto) {
        ProfessorResponseDto atualizado = professorService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        professorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
