package com.external.app.service.impl;

import com.external.app.response.CountryResponse;
import com.external.app.response.SomeResponse;
import com.external.app.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebClientServiceImpl implements WebClientService {

    WebClient webClient;

    @Autowired
    public WebClientServiceImpl(@Qualifier(value = "someWebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public SomeResponse getSomeResponse(String name) {

        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("country", name);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://restcountries.com/v3.1/name/{country}")
                .queryParam("local", "en");

        Flux<CountryResponse> fluxRes = webClient.get().uri(builder.buildAndExpand(pathParams).toUri())
                .retrieve().bodyToFlux(CountryResponse.class);
        CountryResponse res = fluxRes.blockLast();

        return SomeResponse.builder()
                .name(res.getName().getOfficial())
                .age(res.getName().getOfficial().length())
                .build();
    }
}
