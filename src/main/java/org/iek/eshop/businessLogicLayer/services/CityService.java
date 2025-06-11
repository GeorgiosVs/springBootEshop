package org.iek.eshop.businessLogicLayer.services;

import jakarta.validation.Validator;
import org.iek.eshop.businessLogicLayer.dtos.CityDto;
import org.iek.eshop.domainLayer.enities.City;
import org.iek.eshop.domainLayer.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for managing cities
 */
@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private Validator validator;

    /**
     * Retrieves all cities from the repository and converts them to DTOs
     * 
     * @return List of city DTOs
     * @throws Exception if an error occurs
     */
    public List<CityDto> getCities() throws Exception {
        return cityRepository
                .get()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a city by its ID and converts it to DTO
     * 
     * @param id the ID of the city to retrieve
     * @return the city DTO
     * @throws Exception if the city is not found or an error occurs
     */
    public CityDto createCityById(int id) throws Exception {
        City city = cityRepository.getById(id);
        if (city == null) {
            throw new Exception("City not found with ID: " + id);
        }
        return convertToDto(city);
    }

    /**
     * Creates a new city after validating the input DTO
     * 
     * @param cityDto the city DTO to create
     * @return the ID of the created city
     * @throws Exception if validation fails or an error occurs
     */
    public int createCity(CityDto cityDto) throws Exception {
        validateDto(cityDto);

        City city = new City();
        city.name = cityDto.name;
        return cityRepository.create(city);
    }

    /**
     * Updates an existing city after validating the input DTO
     * 
     * @param cityId the ID of the city to update
     * @param cityDto the city DTO with updated values
     * @return the updated city DTO
     * @throws Exception if validation fails or an error occurs
     */
    public CityDto updateCity(Integer cityId, CityDto cityDto) throws Exception {
        validateDto(cityDto);

        // Check if city exists
        City existingCity = cityRepository.getById(cityId);
        if (existingCity == null) {
            throw new Exception("City not found with ID: " + cityId);
        }

        City city = new City();
        city.id = cityId; // Use the path variable ID instead of the DTO ID
        city.name = cityDto.name;
        cityRepository.update(city);

        // Update the DTO ID to match the path variable
        cityDto.id = cityId;
        return cityDto;
    }

    /**
     * Deletes a city by its ID
     * 
     * @param cityId the ID of the city to delete
     * @return the deleted city DTO
     * @throws Exception if the city is not found or an error occurs
     */
    public CityDto deleteCity(Integer cityId) throws Exception {
        City city = cityRepository.getById(cityId);
        if (city == null) {
            throw new Exception("City not found with ID: " + cityId);
        }
        cityRepository.delete(city);
        return convertToDto(city);
    }

    /**
     * Validates a CityDto and throws an exception if validation fails
     * 
     * @param cityDto the city DTO to validate
     * @throws Exception if validation fails
     */
    private void validateDto(CityDto cityDto) throws Exception {
        List<String> validationViolationMessages = validator
                .validate(cityDto)
                .stream()
                .map(v -> v.getMessage())
                .collect(Collectors.toList());

        if (!validationViolationMessages.isEmpty()) {
            throw new Exception(String.join("\n", validationViolationMessages));
        }
    }

    /**
     * Converts a City entity to a CityDto
     * 
     * @param city the city entity to convert
     * @return the converted city DTO
     */
    private CityDto convertToDto(City city) {
        CityDto dto = new CityDto();
        dto.id = city.id;
        dto.name = city.name;
        return dto;
    }
}
