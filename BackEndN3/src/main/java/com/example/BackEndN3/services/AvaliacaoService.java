package com.example.BackEndN3.services;

import com.example.BackEndN3.dtos.AvaliacaoRequestDto;
import com.example.BackEndN3.dtos.AvaliacaoResponseDto;
import com.example.BackEndN3.mappers.AvaliacaoMapper;
import com.example.BackEndN3.models.AvaliacaoEntidade;
import com.example.BackEndN3.models.MateriaEntidade;
import com.example.BackEndN3.repositories.AvaliacaoRepository;
import com.example.BackEndN3.repositories.MateriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    public List<AvaliacaoResponseDto> listarTodas() {
        return avaliacaoRepository.findAll()
                .stream()
                .map(AvaliacaoMapper::toDto)
                .toList();
    }

    public AvaliacaoResponseDto buscarPorId(UUID id) {
        AvaliacaoEntidade avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Avaliação não encontrada"));
        return AvaliacaoMapper.toDto(avaliacao);
    }

    public AvaliacaoResponseDto criar(AvaliacaoRequestDto dto) {
        MateriaEntidade materia = materiaRepository.findById(dto.materiaId())
                .orElseThrow(() -> new EntityNotFoundException("Matéria associada não encontrada"));

        AvaliacaoEntidade avaliacao = AvaliacaoMapper.toEntity(dto, materia);
        AvaliacaoEntidade salva = avaliacaoRepository.save(avaliacao);

        return AvaliacaoMapper.toDto(salva);
    }

    public AvaliacaoResponseDto atualizar(UUID id, AvaliacaoRequestDto dto) {
        AvaliacaoEntidade avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Avaliação não encontrada"));

        MateriaEntidade materia = materiaRepository.findById(dto.materiaId())
                .orElseThrow(() -> new EntityNotFoundException("Matéria associada não encontrada"));

        avaliacao.setNome(dto.nome());
        avaliacao.setPeso(dto.peso());
        avaliacao.setNotaFinal(dto.notaFinal());
        avaliacao.setMateria(materia);

        AvaliacaoEntidade atualizada = avaliacaoRepository.save(avaliacao);

        return AvaliacaoMapper.toDto(atualizada);
    }

    public void deletar(UUID id) {
        if (!avaliacaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Avaliação não encontrada");
        }
        avaliacaoRepository.deleteById(id);
    }
}
