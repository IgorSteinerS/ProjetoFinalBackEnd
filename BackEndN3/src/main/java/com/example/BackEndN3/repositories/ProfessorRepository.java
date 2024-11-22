package com.example.BackEndN3.repositories;

import com.example.BackEndN3.models.AvaliacaoEntidade;
import com.example.BackEndN3.models.ProfessorEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntidade, UUID> {
}
