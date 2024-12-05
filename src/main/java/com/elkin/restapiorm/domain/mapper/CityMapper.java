package com.elkin.restapiorm.domain.mapper;

import com.elkin.restapiorm.domain.dto.CityDTO;
import com.elkin.restapiorm.domain.dto.CountryDTO;
import com.elkin.restapiorm.domain.entity.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper implements IMapper<City, CityDTO>{

    private final CountryMapper countryMapper;

    public CityMapper(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    @Override
    public CityDTO map(City in) {
        CityDTO responseDTO = new CityDTO();

        responseDTO.setId(in.getId());
        responseDTO.setCityName(in.getCityName());
        responseDTO.setCityCode(in.getCityCode());

        CountryDTO countryDTO = this.countryMapper.map(in.getCountry());

        responseDTO.setCountryDTO(countryDTO);

        return responseDTO;
    }
}
