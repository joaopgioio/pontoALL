package com.github.henriquekikuchi.pontoall.service;

import com.github.henriquekikuchi.pontoall.entity.Escola;
import com.github.henriquekikuchi.pontoall.entity.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AulaService {

    Page<Escola> getAll(Pageable pageable);
    Escola getById(Long id);
    Escola save(Escola escola);
    Escola update(Long id, Escola escola);
    void deleteById(Long id);
    Page<Professor> getProfessoresByEscolaId(Pageable pageable, Long escolaId);
}
