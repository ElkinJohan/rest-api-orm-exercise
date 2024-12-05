package com.elkin.restapiorm.service.impl;

import com.elkin.restapiorm.domain.dto.CityDTO;
import com.elkin.restapiorm.domain.dto.CountryDTO;
import com.elkin.restapiorm.domain.entity.City;
import com.elkin.restapiorm.domain.entity.Country;
import com.elkin.restapiorm.domain.mapper.CityMapper;
import com.elkin.restapiorm.domain.mapper.CountryMapper;
import com.elkin.restapiorm.domain.payload.CityForm;
import com.elkin.restapiorm.repository.CityReposiroty;
import com.elkin.restapiorm.repository.CountryRepository;
import com.elkin.restapiorm.service.CityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    private final CityReposiroty cityReposiroty;
    private final CityMapper cityMapper;
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CityServiceImpl(CityReposiroty cityReposiroty, CityMapper cityMapper, CountryRepository countryRepository,
                           CountryMapper countryMapper) {
        this.cityReposiroty = cityReposiroty;
        this.cityMapper = cityMapper;
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public List<CityDTO> getAllCities() {
        List<City> cityList = this.cityReposiroty.findAll();
        List<CityDTO> cityDTOList = new ArrayList<>();

        for (City city :
                cityList) {
            cityDTOList.add(this.cityMapper.map(city));
        }
        return cityDTOList;
    }

    @Override
    public CityDTO getByCityName(String name) {
        City city = this.cityReposiroty.findByCityName(name);
        return this.cityMapper.map(city);
    }

    @Override
    public CityDTO createCity(CityForm cityForm) {

        //encontrando el pais segun el id recibido de cityForm
        Optional<Country> optionalCountry = this.countryRepository.findById(cityForm.getIdCountry());

        //creando una ciudad
        City city = new City();

        city.setCityName(cityForm.getCityName());
        city.setCityCode(cityForm.getCityCode());
        city.setCountry(optionalCountry.get());
        //city.setIdCountry(cityForm.getIdCountry());

        this.cityReposiroty.save(city);

        //creando respuesta dto
        CityDTO responseDTO = this.cityMapper.map(city);

        return responseDTO;
    }

    @Override
    public CityDTO updateCity(CityForm cityForm, Long id) {

        if (this.cityReposiroty.existsById(id)) {
            City city = new City();
            city.setId(id);
            city.setCityName(cityForm.getCityName());
            city.setCityCode(cityForm.getCityCode());

            Optional<Country> optionalCountry = this.countryRepository.findById(cityForm.getIdCountry());

            city.setCountry(optionalCountry.get());

            this.cityReposiroty.save(city);

            return this.cityMapper.map(city);
        } else {
            return null;
        }
    }

}
