package com.example.BackEndN3.mappers;

import com.example.BackEndN3.dtos.AvaliacaoRequestDto;
import com.example.BackEndN3.dtos.AvaliacaoResponseDto;
import com.example.BackEndN3.models.AvaliacaoEntidade;
import com.example.BackEndN3.models.MateriaEntidade;
import org.springframework.stereotype.Component;

@Component
public class AvaliacaoMapper {

    public static AvaliacaoResponseDto toDto(AvaliacaoEntidade avaliacao) {
        if (avaliacao == null) return null;

        return new AvaliacaoResponseDto(
                avaliacao.getId(),
                avaliacao.getNome(),
                avaliacao.getPeso(),
                avaliacao.getNotaFinal(),
                MateriaMapper.toDto(avaliacao.getMateria()) // Mapeia a matéria
        );
    }

    public static AvaliacaoEntidade toEntity(AvaliacaoRequestDto dto, MateriaEntidade materia) {
        if (dto == null) return null;

        AvaliacaoEntidade avaliacao = new AvaliacaoEntidade();
        avaliacao.setNome(dto.nome());
        avaliacao.setPeso(dto.peso());
        avaliacao.setNotaFinal(dto.notaFinal());
        avaliacao.setMateria(materia); // Associação resolvida fora do mapper
        return avaliacao;
    }
}
