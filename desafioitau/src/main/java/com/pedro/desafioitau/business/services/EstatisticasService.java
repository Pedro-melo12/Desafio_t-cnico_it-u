package com.pedro.desafioitau.business.services;


import com.pedro.desafioitau.controllers.dtos.EstastisticasResponseDTO;
import com.pedro.desafioitau.controllers.dtos.TransacaoRequestDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstatisticasService {


    public final TransacaoService transacaoService;

    public EstastisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca){


        List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);

        if(transacoes.isEmpty()){
            return new EstastisticasResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream()
                                                        .mapToDouble(TransacaoRequestDTO::valor)
                                                        .summaryStatistics();



        return new EstastisticasResponseDTO(estatisticasTransacoes.getCount(),
                estatisticasTransacoes.getSum(),
                estatisticasTransacoes.getAverage(),
                estatisticasTransacoes.getMin(),
                estatisticasTransacoes.getMax());
    }

}
