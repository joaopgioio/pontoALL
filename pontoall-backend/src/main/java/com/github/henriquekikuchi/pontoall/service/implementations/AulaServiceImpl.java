package com.github.henriquekikuchi.pontoall.service;

import com.github.henriquekikuchi.pontoall.entity.Aula;
import com.github.henriquekikuchi.pontoall.exception.AulaNotExistsException;
import com.github.henriquekikuchi.pontoall.repository.AulaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AulaServiceImpl implements AulaService{

    private final AulaRepo aulaRepo;

    @Override
    public Page<Aula> getAll(Pageable pageable) {
        return aulaRepo.findAll(pageable);
    }

    @Override
    public Aula getById(Long id) {
        return aulaRepo.findById(id).orElseThrow(AulaNotExistsException::new);
    }

    @Override
    public List<Aula> getAllById(List<Long> ids) {
        return aulaRepo.findAllById(ids);
    }

    @Override
    public Aula save(Aula aula) {
        return aulaRepo.save(aula);
    }

    @Override
    public Aula update(Long id, Aula aula) {
        getById(id);
        aula.setId(id);
        return aulaRepo.save(aula);
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        aulaRepo.deleteById(id);
    }
}
