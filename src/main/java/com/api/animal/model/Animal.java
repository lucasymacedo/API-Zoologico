package com.api.animal.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="animais")
public class Animal {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    //@Column (unique = true)
    private String nome;
    private String descricao;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String especie;
    private String habitat;
    @Column(name = "pais_origem")
    private String paisOrigem;

    public Animal() {
    
    }
    
    public Animal(String nome, String descricao, Date dataNascimento, String especie, String habitat, String paisOrigem) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataNascimento = dataNascimento;
        this.especie = especie;
        this.habitat = habitat;
        this.paisOrigem = paisOrigem;
        
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
        result = prime * result + ((especie == null) ? 0 : especie.hashCode());
        result = prime * result + ((habitat == null) ? 0 : habitat.hashCode());
        result = prime * result + ((paisOrigem == null) ? 0 : paisOrigem.hashCode());
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
        Animal other = (Animal) obj;
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
        if (dataNascimento == null) {
            if (other.dataNascimento != null)
                return false;
        } else if (!dataNascimento.equals(other.dataNascimento))
            return false;
        if (especie == null) {
            if (other.especie != null)
                return false;
        } else if (!especie.equals(other.especie))
            return false;
        if (habitat == null) {
            if (other.habitat != null)
                return false;
        } else if (!habitat.equals(other.habitat))
            return false;
        if (paisOrigem == null) {
            if (other.paisOrigem != null)
                return false;
        } else if (!paisOrigem.equals(other.paisOrigem))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Animal [nome=" + nome + ", descricao=" + descricao + ", dataNascimento=" + dataNascimento + ", especie="
                + especie + ", habitat=" + habitat + ", paisOrigem=" + paisOrigem + "]";
    }

    
}
