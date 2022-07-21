package com.nttdata.mscard.config.endpoints;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointsConfig {

  @Bean
  @ConfigurationProperties(prefix = "http-client.ms-card")
  public Endpoint msProjectBankApiEndpoint() {
    return new Endpoint();
  }

  @Getter
  @Setter
  public static class Endpoint {
    private String baseUrl;
    private long connectTimeout;
    private long readTimeout;
  }
}
