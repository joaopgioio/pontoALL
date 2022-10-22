package com.github.henriquekikuchi.pontoall.service;

import com.github.henriquekikuchi.pontoall.entity.Professor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SerieService {

    Page<Professor> getAll(Pageable pageable);
    Professor getById(Long id);
    Professor save(Professor professor);
    Professor update(Long id, Professor professor);
    void deleteById(Long id);
}
