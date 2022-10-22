package com.github.henriquekikuchi.pontoall.service;

import com.github.henriquekikuchi.pontoall.client.CepApiClient;
import com.github.henriquekikuchi.pontoall.entity.Escola;
import com.github.henriquekikuchi.pontoall.entity.Professor;
import com.github.henriquekikuchi.pontoall.exception.EscolaNotExistsException;
import com.github.henriquekikuchi.pontoall.repository.EscolaRepo;
import com.github.henriquekikuchi.pontoall.repository.ProfessorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EscolaServiceImpl implements EscolaService{

    private final EscolaRepo escolaRepo;
    private final ProfessorRepo professorRepo;


    @Override
    public Page<Escola> getAll(Pageable pageable) {
        return escolaRepo.findAll(pageable);
    }

    @Override
    public Escola getById(Long id) {
        return escolaRepo.findById(id).orElseThrow(EscolaNotExistsException::new);
    }

    @Override
    public Escola save(Escola escola) {
        return escolaRepo.save(escola);
    }

    @Override
    public Escola update(Long id, Escola escola) {
        getById(id);
        escola.setId(id);
        return escolaRepo.save(escola);
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        escolaRepo.deleteById(id);
    }

    @Override
    public Page<Professor> getProfessoresByEscolaId(Pageable pageable, Long escolaId) {
        return professorRepo.findAllByEscolaId(pageable,escolaId);
    }
}
