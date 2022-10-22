package com.github.henriquekikuchi.pontoall.dto;

import com.github.henriquekikuchi.pontoall.entity.enums.MateriaEnum;
import com.github.henriquekikuchi.pontoall.entity.enums.OrdemAulaEnum;

public record AulaRequestCreateDto(
        OrdemAulaEnum ordemAula,
        Long professorId,
        MateriaEnum materia,
        Long gradeId
) {
}
