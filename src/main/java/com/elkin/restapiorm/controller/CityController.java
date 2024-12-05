package com.elkin.restapiorm.controller;

import com.elkin.restapiorm.domain.dto.CityDTO;
import com.elkin.restapiorm.domain.payload.CityForm;
import com.elkin.restapiorm.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping()
    public List<CityDTO> cityDTOList() {
        return this.cityService.getAllCities();
    }

    @GetMapping("/byName/{name}")
    public CityDTO getByCityName(@PathVariable("name") String name){
        return this.cityService.getByCityName(name);
    }

    @PostMapping
    public CityDTO createCity(@RequestBody CityForm cityForm) {
        return this.cityService.createCity(cityForm);
    }

    @PutMapping("/{idCity}")
    public CityDTO updateCity(@RequestBody CityForm cityForm, @PathVariable("idCity") Long idCity){
        return this.cityService.updateCity(cityForm, idCity);
    }


}
