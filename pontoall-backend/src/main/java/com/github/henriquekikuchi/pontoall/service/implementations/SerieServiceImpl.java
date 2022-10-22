package com.github.henriquekikuchi.pontoall.service;

import com.github.henriquekikuchi.pontoall.entity.Serie;
import com.github.henriquekikuchi.pontoall.exception.SerieNotExistsException;
import com.github.henriquekikuchi.pontoall.repository.SerieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SerieServiceImpl implements SerieService {

    private final SerieRepo serieRepo;

    @Override
    public Page<Serie> getAll(Pageable pageable) {
        return serieRepo.findAll(pageable);
    }

    @Override
    public Serie getById(Long id) {
        return serieRepo.findById(id).orElseThrow(SerieNotExistsException::new);
    }

    @Override
    public Serie save(Serie serie) {
        return serieRepo.save(serie);
    }

    @Override
    public Serie update(Long id, Serie serie) {
        getById(id);
        serie.setId(id);
        return serieRepo.save(serie);
    }

    @Override
    public void deleteById(Long id) {
        getById(id);
        serieRepo.deleteById(id);
    }
}
