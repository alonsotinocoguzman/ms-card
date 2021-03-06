package com.nttdata.mscard.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nttdata.mscard.config.endpoints.EndpointsConfig;
import com.nttdata.mscard.proxy.api.MsProjectBankApi;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class RestClientConfig {

  @Bean
  MsProjectBankApi msProjectBankApi(EndpointsConfig.Endpoint msProjectBankApiEndpoint) {
    return getRetrofitConfig(msProjectBankApiEndpoint)
        .addConverterFactory(JacksonConverterFactory.create(getObjectMapper(new ObjectMapper())))
        .build()
        .create(MsProjectBankApi.class);
  }

  private Retrofit.Builder getRetrofitConfig(EndpointsConfig.Endpoint endpoint) {
    return new Retrofit.Builder()
        .baseUrl(endpoint.getBaseUrl())
        .client(getHttpClient(endpoint.getReadTimeout(), endpoint.getConnectTimeout()));
  }

  private OkHttpClient getHttpClient(long readTimeout, long connectTimeout) {
    return new OkHttpClient.Builder()
        .readTimeout(readTimeout, TimeUnit.SECONDS)
        .connectTimeout(connectTimeout, TimeUnit.SECONDS)
        .build();
  }

  private ObjectMapper getObjectMapper(ObjectMapper objectMapper) {
    return objectMapper
        .setSerializationInclusion(JsonInclude.Include.NON_NULL)
        .setDateFormat(new StdDateFormat())
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        .enable(JsonGenerator.Feature.IGNORE_UNKNOWN)
        .enable(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_COMMENTS)
        .registerModule(new JavaTimeModule());
  }
}
