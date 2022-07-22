package com.external.app.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SomeResponse {

    private String name;
    private int age;
}
