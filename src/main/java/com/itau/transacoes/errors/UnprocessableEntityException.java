package com.itau.transacoes.errors;

public class UnprocessableEntityException extends RuntimeException {
  public UnprocessableEntityException(String message) {
    super(message);
  }
}
