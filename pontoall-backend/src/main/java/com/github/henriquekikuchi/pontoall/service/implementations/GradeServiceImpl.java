package com.github.henriquekikuchi.pontoall.service;

import com.github.henriquekikuchi.pontoall.entity.Grade;
import com.github.henriquekikuchi.pontoall.exception.GradeNotExistsException;
import com.github.henriquekikuchi.pontoall.repository.GradeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final GradeRepo gradeRepo;

    @Override
    public Page<Grade> getAll(Pageable pageable) {
        return gradeRepo.findAll(pageable);
    }

    @Override
    public Grade getById(Long id) {
        return gradeRepo.findById(id).orElseThrow(GradeNotExistsException::new);
    }

    @Override
    public Grade save(Grade grade) {
        return gradeRepo.save(grade);
    }

    @Override
    public Grade update(Long id, Grade grade) {
        getById(id);
        grade.setId(id);
        return gradeRepo.save(grade);
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        gradeRepo.deleteById(id);
    }
}
