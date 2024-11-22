package com.example.BackEndN3.mappers;

import com.example.BackEndN3.dtos.MateriaRequestDto;
import com.example.BackEndN3.dtos.MateriaResponseDto;
import com.example.BackEndN3.models.MateriaEntidade;
import com.example.BackEndN3.models.ProfessorEntidade;
import org.springframework.stereotype.Component;

@Component
public class MateriaMapper {

    public static MateriaResponseDto toDto(MateriaEntidade materia) {
        if (materia == null) return null;

        return new MateriaResponseDto(
                materia.getId(),
                materia.getNome(),
                ProfessorMapper.toDto(materia.getProfessor()) // Mapeia o professor
        );
    }

    public static MateriaEntidade toEntity(MateriaRequestDto dto, ProfessorEntidade professor) {
        if (dto == null) return null;

        MateriaEntidade materia = new MateriaEntidade();
        materia.setNome(dto.nome());
        materia.setProfessor(professor); // Associação resolvida fora do mapper
        return materia;
    }
}
