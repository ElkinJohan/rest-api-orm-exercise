package com.elkin.restapiorm.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CountryDTO {
    //@JsonIgnore
    private Long id;
    private String countryName;
}
