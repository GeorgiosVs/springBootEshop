package org.iek.eshop.businessLogicLayer.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object for City entity
 */
public class CityDto {
    public int id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    public String name;

    /**
     * Default constructor
     */
    public CityDto() {
    }

    /**
     * Constructor with parameters
     * 
     * @param id the city ID
     * @param name the city name
     */
    public CityDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the city ID
     * 
     * @return the city ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the city ID
     * 
     * @param id the city ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the city name
     * 
     * @return the city name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the city name
     * 
     * @param name the city name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
