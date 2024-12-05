package com.elkin.restapiorm.domain.mapper;

public interface IMapper <I, O>{
    public O map(I in);
}
