package org.iek.eshop.domainLayer.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.iek.eshop.domainLayer.enities.City;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Repository
public class CitiesRepository {
    @PersistenceContext
    private EntityManager entityMgr;

    public List<City> get(){
        List<City> result = entityMgr
                .createQuery("SELECT c FROM cities c", City.class)
                .getResultStream()
                .collect(Collectors.toList());
        return new ArrayList<City>(result);
    }
}
