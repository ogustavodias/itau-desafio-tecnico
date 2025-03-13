package com.itau.transacoes.models;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Transacao {
  @NotNull
  private Double valor;

  @NotNull
  private OffsetDateTime dataHora;
}
