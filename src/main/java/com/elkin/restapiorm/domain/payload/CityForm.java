package com.elkin.restapiorm.domain.payload;

import lombok.Data;

@Data
public class CityForm {
    private String cityName;
    private String cityCode;
    private Long idCountry;
}
