package com.external.app.config;

import com.external.app.response.SomeErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Configuration
public class AppConfig {

    @Bean(name = "someRestTemplate")
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(120))
                .errorHandler(new SomeErrorHandler()).build();
        // .requestFactory(this::clientHttpRequestFactory)
    }

    @Bean(name = "someOtherRestTemplate")
    public RestTemplate getSomeOtherRestTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(3))
                .errorHandler(new SomeErrorHandler()).build();
        // .requestFactory(this::clientHttpRequestFactory)
    }

    @Bean(name = "someWebClient")
    public WebClient getWebClient(){
        return WebClient.builder().build();
    }
}
