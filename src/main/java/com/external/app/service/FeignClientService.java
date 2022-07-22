package com.external.app.service;

import com.external.app.response.SomeResponse;

public interface FeignClientService {

    public SomeResponse getSomeResponse(int number);
}
