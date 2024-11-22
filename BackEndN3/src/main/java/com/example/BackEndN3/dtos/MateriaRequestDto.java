package com.example.BackEndN3.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record MateriaRequestDto(
        @NotBlank String nome,
        @NotNull UUID professorId
        ) {
}
