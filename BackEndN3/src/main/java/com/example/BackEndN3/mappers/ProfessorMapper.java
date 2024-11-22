package com.example.BackEndN3.mappers;

import com.example.BackEndN3.dtos.ProfessorRequestDto;
import com.example.BackEndN3.dtos.ProfessorResponseDto;
import com.example.BackEndN3.models.ProfessorEntidade;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public static ProfessorResponseDto toDto(ProfessorEntidade professor) {
        if (professor == null) return null;

        return new ProfessorResponseDto(
                professor.getId(),
                professor.getNome()
        );
    }

    public static ProfessorEntidade toEntity(ProfessorRequestDto dto) {
        if (dto == null) return null;

        ProfessorEntidade professor = new ProfessorEntidade();
        professor.setNome(dto.nome());
        return professor;
    }
}
