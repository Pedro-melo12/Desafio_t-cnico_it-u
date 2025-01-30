package com.pedro.desafioitau.controllers;


import com.pedro.desafioitau.business.services.TransacaoService;
import com.pedro.desafioitau.controllers.dtos.TransacaoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;


    @PostMapping
    @Operation(description = "Endpoint Responsável por adicionar Transações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description = "Transação gravada com sucesso"),
            @ApiResponse(responseCode = "422",description = "Campos não atendem os requisitos da transação"),
            @ApiResponse(responseCode = "400",description = "Erro de requisição"),
            @ApiResponse(responseCode = "500",description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto){

        transacaoService.addTransacoes(dto);

        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @Operation(description = "Endpoint Responsável por deletar Transações")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Transação deletadas com sucesso"),
            @ApiResponse(responseCode = "400",description = "Erro de requisição"),
            @ApiResponse(responseCode = "500",description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> deletarTransacoes (){
        transacaoService.excluirTransacoes();
        return ResponseEntity.ok().build();
    }
}
