package com.external.app.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Languages {
    public String aym;
    public String que;
    public String spa;
}
