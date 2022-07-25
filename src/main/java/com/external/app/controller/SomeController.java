package com.external.app.controller;

import com.external.app.request.SomeRequest;
import com.external.app.response.SomeResponse;
import com.external.app.service.SomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(path = "/something")
public class SomeController {

    public static final Logger log = LoggerFactory.getLogger(SomeController.class);

    SomeService service;

    @Autowired
    private SomeController(SomeService service) {
        this.service = service;
    }

    @GetMapping(value = "/{number}/validate")
    public ResponseEntity<SomeResponse> myMthod(@RequestHeader(name = "auth", required = false) final String auth,
                                                @PathVariable(name = "number", required = false) final String number,
                                                @RequestParam(name = "local", required = false, defaultValue = "EN") final String local) {
        log.info("something auth:{} number:{} local:{} ", auth, number, local);
        SomeResponse res = null;
        try {
            res = service.getSomeResponse(number);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<SomeResponse> saveMethod(@RequestBody SomeRequest payload) {
        log.info("saveMethod payload :{} ", payload);
        SomeResponse res = null;
        try {
            res = service.getSomeResponse("SRL");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}