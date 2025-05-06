package org.iek.eshop;

import org.assertj.core.api.Assertions;
import org.iek.eshop.domainLayer.enities.City;
import org.iek.eshop.domainLayer.repositories.CityRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class domainLayerTest {
    @Autowired
    private CityRepository CityRepository;

    @Test
    void contextLoads(){
        List<City> cities = CityRepository.get();
        Assertions.assertThat(cities).isNotNull();
        Assertions.assertThat(cities.size()).isGreaterThan(0);
    }
}