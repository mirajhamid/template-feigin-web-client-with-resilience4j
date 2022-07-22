package com.external.app.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CountryResponse {
    public Name name;
    public ArrayList<String> tld;
    public String status;
    public boolean unMember;
    public Languages languages;
    public String flag;
    public PostalCode postalCode;
}







