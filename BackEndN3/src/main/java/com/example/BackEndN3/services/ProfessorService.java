package com.example.BackEndN3.services;

import com.example.BackEndN3.dtos.ProfessorRequestDto;
import com.example.BackEndN3.dtos.ProfessorResponseDto;
import com.example.BackEndN3.mappers.ProfessorMapper;
import com.example.BackEndN3.models.ProfessorEntidade;
import com.example.BackEndN3.repositories.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<ProfessorResponseDto> listarTodos() {
        return professorRepository.findAll()
                .stream()
                .map(ProfessorMapper::toDto)
                .toList();
    }

    public ProfessorResponseDto buscarPorId(UUID id) {
        ProfessorEntidade professor = professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));
        return ProfessorMapper.toDto(professor);
    }

    public ProfessorResponseDto criar(ProfessorRequestDto dto) {
        ProfessorEntidade professor = ProfessorMapper.toEntity(dto);
        ProfessorEntidade salvo = professorRepository.save(professor);
        return ProfessorMapper.toDto(salvo);
    }

    public ProfessorResponseDto atualizar(UUID id, ProfessorRequestDto dto) {
        ProfessorEntidade professor = professorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));

        professor.setNome(dto.nome());
        ProfessorEntidade atualizado = professorRepository.save(professor);

        return ProfessorMapper.toDto(atualizado);
    }

    public void deletar(UUID id) {
        if (!professorRepository.existsById(id)) {
            throw new EntityNotFoundException("Professor não encontrado");
        }
        professorRepository.deleteById(id);
    }
}

