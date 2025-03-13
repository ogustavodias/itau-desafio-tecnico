package com.itau.transacoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itau.transacoes.models.Estatistica;
import com.itau.transacoes.models.Transacao;
import com.itau.transacoes.services.TransacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

  @Autowired
  private TransacaoService service;

  @PostMapping
  public ResponseEntity<Void> registrarTransacao(@Valid @RequestBody Transacao transacao) {
    service.registrarTransacao(transacao);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping
  public ResponseEntity<Estatistica> obterEstatisticaDasUltimasTransacoes(@RequestParam int seconds) {
    Estatistica estatistica = service.obterEstatisticaDasUltimasTransacoes(seconds);
    return ResponseEntity.status(HttpStatus.OK).body(estatistica);
  }

  @DeleteMapping
  public ResponseEntity<Void> deletarTransacoes() {
    service.deletarTransacoes();
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
