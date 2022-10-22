package com.github.henriquekikuchi.pontoall.entity;

import javax.persistence.Embeddable;

public enum MateriaEnum {
    PORTUGUES("Portugues"),
    MATEMATICA("Matematica"),
    HISTORIA("Historia"),
    GEOGRAFIA("Geografia"),
    CIENCIAS("Ciencias"),
    EDUCACAO_FISICA("Educacao Fisica"),
    ARTES("Artes");

    private String descricao;

    MateriaEnum(String descricao){
        this.descricao = descricao;
    }
}
