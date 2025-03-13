package com.itau.transacoes.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Void> handleAll(Exception e) {
    logger.error("Ocorreu um erro inesperado: " + e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
  }

  @ExceptionHandler(UnprocessableEntityException.class)
  public ResponseEntity<Void> handleUnprocesableEntityException(UnprocessableEntityException e) {
    logger.error("Ocorreu um erro inesperado: " + e.getMessage());
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
  }

}
