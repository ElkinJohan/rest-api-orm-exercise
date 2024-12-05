package com.elkin.restapiorm.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities")
public class City {

    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "city_code", nullable = false, length = 3)
    private String cityCode;

    @Transient
    private String beanId;

    @Column(name = "country_id")
    private Long idCountry;

    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    @JsonIgnore
    private Country country;

}
