package com.example.BackEndN3.controllers;

import com.example.BackEndN3.dtos.MateriaRequestDto;
import com.example.BackEndN3.dtos.MateriaResponseDto;
import com.example.BackEndN3.services.MateriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public ResponseEntity<List<MateriaResponseDto>> listarTodas() {
        List<MateriaResponseDto> materias = materiaService.listarTodas();
        return ResponseEntity.ok(materias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaResponseDto> buscarPorId(@PathVariable UUID id) {
        MateriaResponseDto materia = materiaService.buscarPorId(id);
        return ResponseEntity.ok(materia);
    }

    @PostMapping
    public ResponseEntity<MateriaResponseDto> criar(@Valid @RequestBody MateriaRequestDto dto) {
        MateriaResponseDto novaMateria = materiaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMateria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MateriaResponseDto> atualizar(
            @PathVariable UUID id,
            @Valid @RequestBody MateriaRequestDto dto) {
        MateriaResponseDto atualizada = materiaService.atualizar(id, dto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        materiaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
