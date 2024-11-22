package com.example.BackEndN3.dtos;



import java.util.UUID;

public record MateriaResponseDto(
        UUID id,
        String nome,
        ProfessorResponseDto professor
) {
}
