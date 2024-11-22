package com.example.BackEndN3.services;

import com.example.BackEndN3.dtos.MateriaRequestDto;
import com.example.BackEndN3.dtos.MateriaResponseDto;
import com.example.BackEndN3.mappers.MateriaMapper;
import com.example.BackEndN3.models.MateriaEntidade;
import com.example.BackEndN3.models.ProfessorEntidade;
import com.example.BackEndN3.repositories.MateriaRepository;
import com.example.BackEndN3.repositories.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public List<MateriaResponseDto> listarTodas() {
        return materiaRepository.findAll()
                .stream()
                .map(MateriaMapper::toDto)
                .toList();
    }

    public MateriaResponseDto buscarPorId(UUID id) {
        MateriaEntidade materia = materiaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matéria não encontrada"));
        return MateriaMapper.toDto(materia);
    }

    public MateriaResponseDto criar(MateriaRequestDto dto) {
        ProfessorEntidade professor = professorRepository.findById(dto.professorId())
                .orElseThrow(() -> new EntityNotFoundException("Professor associado não encontrado"));

        MateriaEntidade materia = MateriaMapper.toEntity(dto, professor);
        MateriaEntidade salva = materiaRepository.save(materia);

        return MateriaMapper.toDto(salva);
    }

    public MateriaResponseDto atualizar(UUID id, MateriaRequestDto dto) {
        MateriaEntidade materia = materiaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matéria não encontrada"));

        ProfessorEntidade professor = professorRepository.findById(dto.professorId())
                .orElseThrow(() -> new EntityNotFoundException("Professor associado não encontrado"));

        materia.setNome(dto.nome());
        materia.setProfessor(professor);

        MateriaEntidade atualizada = materiaRepository.save(materia);

        return MateriaMapper.toDto(atualizada);
    }

    public void deletar(UUID id) {
        if (!materiaRepository.existsById(id)) {
            throw new EntityNotFoundException("Matéria não encontrada");
        }
        materiaRepository.deleteById(id);
    }
}
