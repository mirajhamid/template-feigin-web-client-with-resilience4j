package com.external.app.service.impl;

import com.external.app.response.SomeResponse;
import com.external.app.service.RestTemplateService;
import com.external.app.service.SomeService;
import com.external.app.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SomeServiceImpl implements SomeService {

    RestTemplateService restTemplateService;
    WebClientService webClientService;

    @Autowired
    public SomeServiceImpl(RestTemplateService restTemplateService, WebClientService webClientService)
    {
        this.restTemplateService = restTemplateService;
        this.webClientService = webClientService;
    }


    @Override
    public SomeResponse getSomeResponse(String name) throws IOException {
        SomeResponse res = restTemplateService.getSomeResponse(name);
        SomeResponse res2 = webClientService.getSomeResponse(name);
        return res;
    }
}
