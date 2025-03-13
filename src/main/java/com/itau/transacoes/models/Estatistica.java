package com.itau.transacoes.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Getter
public class Estatistica {
  private Double min;
  private Double max;

  @JsonIgnore
  private List<Transacao> transacoes;

  private Estatistica(List<Transacao> transacoes) {
    this.transacoes = transacoes;
  }

  public static Estatistica obterEstatisticas(List<Transacao> transacoes) {
    Estatistica estatistica = new Estatistica(transacoes);
    estatistica.calcMin();
    estatistica.calcMax();
    return estatistica;
  }

  private void calcMin() {
    Double min = null;

    for (Transacao transacao : this.transacoes) {
      if (min == null || transacao.getValor() < min)
        min = transacao.getValor();
    }

    this.min = min;
  }

  private void calcMax() {
    Double max = null;

    for (Transacao transacao : this.transacoes) {
      if (max == null || transacao.getValor() > max)
        max = transacao.getValor();
    }

    this.max = max;
  }

}
