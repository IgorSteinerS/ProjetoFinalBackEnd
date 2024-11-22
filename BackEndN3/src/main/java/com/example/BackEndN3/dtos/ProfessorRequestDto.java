package com.example.BackEndN3.dtos;

import jakarta.validation.constraints.NotBlank;

public record ProfessorRequestDto(
        @NotBlank String nome
) {

    @Override
    public @NotBlank String nome() {
        return nome;
    }
}
