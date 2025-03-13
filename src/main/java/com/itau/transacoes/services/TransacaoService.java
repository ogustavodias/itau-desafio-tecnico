package com.itau.transacoes.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.itau.transacoes.errors.UnprocessableEntityException;
import com.itau.transacoes.models.Transacao;

@Service
public class TransacaoService {

  private static final Logger logger = LoggerFactory.getLogger(TransacaoService.class);
  private static final List<Transacao> transacoes = new ArrayList<>();

  public void registrarTransacao(Transacao transacao) {
    validarTransacao(transacao); // Se inválida, uma exceção será lançada
    transacoes.add(transacao);
    logger.info("Transação registrada com sucesso: " + transacao);
  }

  public void deletarTransacoes() {
    logger.info("Limpando todas as transações");
    transacoes.clear();
  }

  public void validarTransacao(Transacao transacao) throws ResponseStatusException {
    logger.info("Validando a transação");

    String mensagemDeErro = "";
    OffsetDateTime offsetDateTimeNow = OffsetDateTime.now();

    if (transacao.getValor() < 0)
      mensagemDeErro += "O valor da transação não pode ser menor que 0;";

    if (transacao.getDataHora().isAfter(offsetDateTimeNow))
      mensagemDeErro += "Não é possível registrar uma transação futura;";

    if (mensagemDeErro.length() > 0)
      throw new UnprocessableEntityException(mensagemDeErro);
  }

}
