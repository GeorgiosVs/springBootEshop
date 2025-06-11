package org.iek.eshop.domainLayer.enities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity representing a city in the database
 */
@Entity
@Table(name = "cities")
public class City {
    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "name")
    public String name;

    /**
     * Default constructor
     */
    public City() {
    }

    /**
     * Constructor with parameters
     * 
     * @param id the city ID
     * @param name the city name
     */
    public City(int id, String name) {
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
