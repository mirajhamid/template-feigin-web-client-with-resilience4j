package com.external.app.controller;

import com.external.app.response.SomeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControlAdvice {

    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<SomeResponse> handleRunTimeException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(SomeResponse.builder().age(-1).name(null).build());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<SomeResponse> handleRunTimeException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(SomeResponse.builder().age(-2).name(null).build());
    }

}
