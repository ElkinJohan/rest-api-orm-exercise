package com.elkin.restapiorm.service;


import com.elkin.restapiorm.domain.dto.CityDTO;
import com.elkin.restapiorm.domain.payload.CityForm;

import java.util.List;

public interface CityService {

    List<CityDTO> getAllCities();

    CityDTO getByCityName(String name);

    CityDTO createCity(CityForm cityForm);

    CityDTO updateCity(CityForm cityForm, Long id);
}
