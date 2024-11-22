package com.example.BackEndN3.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class AvaliacaoEntidade {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer Peso;

    @Column
    private Integer notaFinal;

    @ManyToOne
    @JoinColumn(name = "materia_id", nullable = false)
    private MateriaEntidade materia;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MateriaEntidade getMateria() {
        return materia;
    }

    public void setMateria(MateriaEntidade materia) {
        this.materia = materia;
    }

    public Integer getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Integer notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Integer getPeso() {
        return Peso;
    }

    public void setPeso(Integer peso) {
        Peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
