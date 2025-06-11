package org.iek.eshop.domainLayer.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.iek.eshop.domainLayer.enities.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for managing City entities
 */
@Repository
@Transactional
public class CityRepository {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Retrieves all cities from the database
     * 
     * @return List of all cities
     */
    public List<City> get() {
        TypedQuery<City> query = entityManager.createQuery("SELECT c FROM City c", City.class);
        return query.getResultList();
    }

    /**
     * Creates a new city in the database
     * 
     * @param city the city to create
     * @return the ID of the created city
     */
    public int create(City city) {
        entityManager.persist(city);
        entityManager.flush();
        return city.getId();
    }

    /**
     * Updates an existing city in the database
     * 
     * @param city the city with updated values
     */
    public void update(City city) {
        entityManager.merge(city);
        entityManager.flush();
    }

    /**
     * Retrieves a city by its ID
     * 
     * @param id the ID of the city to retrieve
     * @return the city with the specified ID or null if not found
     */
    public City getById(int id) {
        return entityManager.find(City.class, id);
    }

    /**
     * Deletes a city from the database
     * 
     * @param city the city to delete
     */
    public void delete(City city) {
        entityManager.remove(city);
        entityManager.flush();
    }
}
