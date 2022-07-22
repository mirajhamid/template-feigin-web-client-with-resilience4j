package com.external.app.service.impl;

import com.external.app.response.CountryResponse;
import com.external.app.response.SomeResponse;
import com.external.app.service.RestTemplateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    RestTemplate restTemplate;

    @Autowired
    public RestTemplateServiceImpl(@Qualifier("someRestTemplate")
                                   RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SomeResponse getSomeResponse(String name) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.set("something", "something");
        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("country", name);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://restcountries.com/v3.1/name/{country}")
                .queryParam("local", "en");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(builder.buildAndExpand(pathParams).toUri(),
                HttpMethod.GET,
                entity, String.class);
        ObjectMapper mapper = new ObjectMapper();
        CountryResponse[] res = mapper.readValue(response.getBody(), CountryResponse[].class);

        return SomeResponse.builder()
                .name(res[0].getName().getOfficial())
                .age(res[0].getName().getOfficial().length())
                .build();
    }
}
