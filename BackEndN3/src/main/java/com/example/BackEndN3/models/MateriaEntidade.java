package com.example.BackEndN3.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class MateriaEntidade {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private ProfessorEntidade professor;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProfessorEntidade getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntidade professor) {
        this.professor = professor;
    }
}
