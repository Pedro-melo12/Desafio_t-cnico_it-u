package com.pedro.desafioitau.controllers.dtos;

public record EstastisticasResponseDTO(Long count,
                                       Double sum,
                                       Double avg,
                                       Double min,
                                       Double max) {
}
