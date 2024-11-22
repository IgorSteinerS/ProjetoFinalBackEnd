package com.example.BackEndN3.dtos;

import java.util.UUID;

public record ProfessorResponseDto(
        UUID id,
        String nome
) {
}
