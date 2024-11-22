package com.example.BackEndN3.dtos;





import java.util.UUID;

public record AvaliacaoResponseDto(
        UUID id,
        String nome,
        Integer peso,
        Integer notaFinal,
        MateriaResponseDto materia) {
}
