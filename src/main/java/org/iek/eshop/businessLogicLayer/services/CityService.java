package org.iek.eshop.businessLogicLayer.services;


import jakarta.validation.Validator;
import org.iek.eshop.businessLogicLayer.dtos.CityDto;
import org.iek.eshop.domainLayer.enities.City;
import org.iek.eshop.domainLayer.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService
{
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private Validator validator;

    public int createCity(CityDto c) throws Exception
    {
        List<String> validationViolationMessages = validator
                .validate(c)
                .stream()
                .map(v -> v.getMessage())
                .collect(Collectors.toList());
        if (validationViolationMessages.size() > 0)
            throw new Exception(String.join("\n", validationViolationMessages));
        int id = cityRepository
                .create(new City() {{ name = c.name; }});
        return id;
    }
    public CityDto updateCity(CityDto c) throws Exception
    {
        List<String> validationViolationMessages = validator.validate(c).stream().map(v -> v.getMessage()).collect(Collectors.toList());
        if (validationViolationMessages.size() > 0)
            throw new Exception(String.join("\n", validationViolationMessages));
        cityRepository
                .update(new City() {{ id = c.id; name = c.name; }});
        return c;
    }
}