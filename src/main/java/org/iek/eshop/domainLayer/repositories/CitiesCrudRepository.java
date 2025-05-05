package org.iek.eshop.domainLayer.repositories;

import jakarta.transaction.Transactional;
import org.iek.eshop.domainLayer.enities.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CitiesCrudRepository extends CrudRepository<City, Integer> {
}
