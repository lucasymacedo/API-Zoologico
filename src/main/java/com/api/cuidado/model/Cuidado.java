package com.api.cuidado.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuidados")
public class Cuidado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private String descricao;
    private String frequencia;

    public Cuidado(String nome, String descricao, String frequencia) {
        this.nome = nome;
        this.descricao = descricao;
        this.frequencia = frequencia;
    }

    public Cuidado() { 

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((frequencia == null) ? 0 : frequencia.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cuidado other = (Cuidado) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (frequencia == null) {
            if (other.frequencia != null)
                return false;
        } else if (!frequencia.equals(other.frequencia))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cuidado [nome=" + nome + ", descricao=" + descricao + ", frequencia=" + frequencia + "]";
    }

        
}
