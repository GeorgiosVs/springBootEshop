package org.iek.eshop.domainLayer.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.iek.eshop.domainLayer.enities.City;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
@Transactional
public class CityRepository {
    @PersistenceContext
    private EntityManager entityMgr;

    public List<City> get(){
        List<City> result = entityMgr
                .createQuery("SELECT c FROM City c", City.class)
                .getResultStream()
                .collect(Collectors.toList());
        return new ArrayList<City>(result);
    }

    public int create(City city){
        entityMgr.persist(city);
        entityMgr.flush();
        return city.id;
    }

    public void update(City city){
        entityMgr.merge(city);
        entityMgr.flush();
    }

    public City findById(int id){
        return entityMgr.find(City.class, id);
    }
}
