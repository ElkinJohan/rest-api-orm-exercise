package com.elkin.restapiorm.repository;

import com.elkin.restapiorm.domain.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityReposiroty extends JpaRepository<City, Long> {

    City findByCityName(String name);
}
