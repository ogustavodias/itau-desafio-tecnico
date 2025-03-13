package com.itau.transacoes.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;

@Getter
public class Estatistica {
  private int count;
  private Double sum;
  private Double avg;
  private Double min;
  private Double max;

  @JsonIgnore
  private List<Transacao> transacoes;

  private Estatistica(List<Transacao> transacoes) {
    this.transacoes = transacoes;
  }

  public static Estatistica obterEstatisticas(List<Transacao> transacoes) {
    Estatistica estatistica = new Estatistica(transacoes);
    estatistica.calcCount();
    estatistica.calcSum();
    estatistica.calcAvg();
    estatistica.calcMin();
    estatistica.calcMax();
    return estatistica;
  }

  private void calcCount() {
    this.count = this.transacoes.size();
  }

  private void calcSum() {
    this.sum = this.transacoes.stream().mapToDouble(Transacao::getValor).sum();
  }

  private void calcAvg() {
    this.avg = this.transacoes.stream().mapToDouble(Transacao::getValor).average().orElse(0.0);
  }

  private void calcMin() {
    this.min = this.transacoes.stream().mapToDouble(Transacao::getValor).min().orElse(0.0);
  }

  private void calcMax() {
    this.max = this.transacoes.stream().mapToDouble(Transacao::getValor).max().orElse(0.0);
  }

}
