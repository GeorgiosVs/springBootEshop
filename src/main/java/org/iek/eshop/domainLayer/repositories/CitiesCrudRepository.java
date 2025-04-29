package org.iek.eshop.domainLayer.repositories;

import org.iek.eshop.domainLayer.enities.City;
import org.springframework.data.repository.CrudRepository;

public interface CitiesCrudRepository extends CrudRepository<City, Integer> {
    City findById(int id);
}
