package org.iek.eshop.apiLayer.Controllers;

import java.util.List;

import org.iek.eshop.businessLogicLayer.dtos.CityDto;
import org.iek.eshop.businessLogicLayer.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing cities
 */
@RestController
@RequestMapping("cities")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * GET /cities : Get all cities
     * 
     * @return ResponseEntity with list of cities or error message
     */
    @GetMapping
    public ResponseEntity<?> getAllCities() {
        try {
            List<CityDto> response = cityService.getCities();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Error retrieving cities: " + e.getMessage());
        }
    }

    /**
     * GET /cities/get/{id} : Get city by id
     * 
     * @param cityId the id of the city to retrieve
     * @return ResponseEntity with the city or error message
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCityById(@PathVariable("id") Integer cityId) {
        try {
            CityDto response = cityService.createCityById(cityId);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Error retrieving city: " + e.getMessage());
        }
    }

    /**
     * POST /cities : Create a new city
     * 
     * @param cityDto the city to create
     * @return ResponseEntity with the created city id or error message
     */
    @PostMapping
    public ResponseEntity<?> createCity(@RequestBody CityDto cityDto) {
        try {
            int id = cityService.createCity(cityDto);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Error creating city: " + e.getMessage());
        }
    }

    /**
     * PUT /cities/{id} : Update an existing city
     * 
     * @param cityId the id of the city to update
     * @param cityDto the city with updated values
     * @return ResponseEntity with the updated city or error message
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCity(@PathVariable("id") Integer cityId, @RequestBody CityDto cityDto) {
        try {
            CityDto updatedCity = cityService.updateCity(cityId, cityDto);
            return ResponseEntity.ok(updatedCity);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Error updating city: " + e.getMessage());
        }
    }

    /**
     * DELETE /cities/{id} : Delete a city
     * 
     * @param cityId the id of the city to delete
     * @return ResponseEntity with the deleted city or error message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable("id") Integer cityId) {
        try {
            CityDto deletedCity = cityService.deleteCity(cityId);
            return ResponseEntity.ok(deletedCity);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body("Error deleting city: " + e.getMessage());
        }
    }
}
