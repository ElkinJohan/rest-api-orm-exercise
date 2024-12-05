package com.elkin.restapiorm.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class CityDTO {
    //@JsonIgnore
    private Long id;
    private String cityName;
    private String cityCode;
    private CountryDTO countryDTO;
}
