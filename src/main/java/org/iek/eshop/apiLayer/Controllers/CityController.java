package org.iek.eshop.apiLayer.Controllers;

import java.util.List;

import org.iek.eshop.businessLogicLayer.dtos.CityDto;
import org.iek.eshop.businessLogicLayer.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public CityDto getCityById(@PathVariable ("id") Integer cityId) throws Exception {
        return cityService.createCityById(cityId);
    }

    @PostMapping
    public void createCity(@RequestBody CityDto cityDto) throws Exception {
        try {
             cityService.createCity(cityDto);
         }
         catch (Exception x){
             throw new Exception("Error creating city");
         }
    }

    @PutMapping("/{id}")
    public void updateCity(@PathVariable("id") Integer cityId, @RequestBody CityDto cityDto) throws Exception {
        try {
             cityService.updateCity(cityId, cityDto);
         }
         catch (Exception x){
             throw new Exception("Error updating city");
         }
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable("id") Integer cityId) throws Exception {
        try{
            cityService.deleteCity(cityId);
        }
        catch (Exception x){
            throw new Exception("Error deleting city");
        }
    }
}