package com.example.BackEndN3.dtos;


import jakarta.validation.constraints.*;


import java.util.UUID;

public record AvaliacaoRequestDto(
        @NotBlank String nome,
        @NotNull @Positive Integer peso,
        @PositiveOrZero Integer notaFinal,
        @NotNull UUID materiaId
) {
}
