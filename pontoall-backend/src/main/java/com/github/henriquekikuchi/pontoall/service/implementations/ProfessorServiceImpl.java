package com.github.henriquekikuchi.pontoall.service;

import com.github.henriquekikuchi.pontoall.entity.Professor;
import com.github.henriquekikuchi.pontoall.exception.ProfessorNotExistsException;
import com.github.henriquekikuchi.pontoall.repository.ProfessorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepo professorRepo;

    @Override
    public Page<Professor> getAll(Pageable pageable) {
        return professorRepo.findAll(pageable);
    }

    @Override
    public Professor getById(Long id) {
        return professorRepo.findById(id).orElseThrow(ProfessorNotExistsException::new);
    }

    @Override
    public Professor save(Professor professor) {
        return professorRepo.save(professor);
    }

    @Override
    public Professor update(Long id, Professor professor) {
        getById(id);
        professor.setId(id);
        return professorRepo.save(professor);
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        professorRepo.deleteById(id);
    }
}
