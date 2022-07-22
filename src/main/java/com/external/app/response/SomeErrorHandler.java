package com.external.app.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

public class SomeErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        //handle response and let it know yes has error in response
        return !(response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        throw new RuntimeException("This is handled runtime exception");
    }
}
