package com.external.app.service;

import com.external.app.response.SomeResponse;

import java.io.IOException;

public interface SomeService {

    public SomeResponse getSomeResponse(String name) throws IOException;
}
