package com.elkin.restapiorm.domain.mapper;

import com.elkin.restapiorm.domain.dto.CountryDTO;
import com.elkin.restapiorm.domain.entity.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper implements IMapper<Country, CountryDTO>{

    @Override
    public CountryDTO map(Country in) {
        CountryDTO responseDTO = new CountryDTO();

        responseDTO.setId(in.getId());
        responseDTO.setCountryName(in.getCountryName());

        return responseDTO;
    }
}
