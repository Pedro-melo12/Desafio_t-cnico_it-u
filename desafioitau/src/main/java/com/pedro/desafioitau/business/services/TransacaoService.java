package com.pedro.desafioitau.business.services;


import com.pedro.desafioitau.controllers.dtos.TransacaoRequestDTO;
import com.pedro.desafioitau.infra.exceptions.UnprocessableEntity;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class TransacaoService {

     private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

     public void addTransacoes(TransacaoRequestDTO dto){



         if(dto.dataHora().isAfter(OffsetDateTime.now())){

             throw new UnprocessableEntity("Data e hora maiores que a data e horas atuais");
         }
         if(dto.valor() < 0){

             throw new UnprocessableEntity("Valor não pode ser menor que 0");
         }


         listaTransacoes.add(dto);


     }

     public void excluirTransacoes(){

         listaTransacoes.clear();

    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca){


         OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);


         return listaTransacoes.stream().
                 filter(transacao -> transacao.dataHora()
                         .isAfter(dataHoraIntervalo)).toList();

    }
}
