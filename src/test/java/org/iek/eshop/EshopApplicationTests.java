package org.iek.eshop;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.iek.eshop.domainLayer.enities.City;
import org.iek.eshop.domainLayer.repositories.CitiesCrudRepository;
import org.iek.eshop.domainLayer.repositories.CitiesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EshopApplicationTests {
    @Autowired
    private CitiesRepository CitiesRepository;

    @Autowired
    private CitiesCrudRepository CitiesCrudRepository;
    @Autowired
    private CitiesCrudRepository citiesCrudRepository;

    @Test
    void testCitiesRepo(){
    List<City> cities = CitiesRepository.get();

    Assertions.assertThat(cities.size()).isGreaterThan(0);
    }

    @Test
    void testCitiesCrudRepo(){
        List<City> cities = Lists
                .newArrayList(citiesCrudRepository.findAll());
        Assertions.assertThat(cities.size()).isNotNegative();
        Assertions.assertThat(cities.size()).isGreaterThan(0);
    }

}
