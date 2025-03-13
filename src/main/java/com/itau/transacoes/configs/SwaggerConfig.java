package com.itau.transacoes.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI().info(
        new Info()
            .title("API de transações")
            .version("1.0")
            .description("API para registro de transações e retorno de suas respectivas estatísticas."));
  }
}