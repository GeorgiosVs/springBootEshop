package org.iek.eshop.apiLayer.Controllers;

import java.util.List;

import org.iek.eshop.businessLogicLayer.dtos.CityDto;
import org.iek.eshop.businessLogicLayer.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/get")
    public List<CityDto> getCities() throws Exception {
        return cityService.getCities();
    }
    @GetMapping("/get/{id}")
    public CityDto getCityById(int id) throws Exception {
        return cityService.createCityById(id);
    }
}