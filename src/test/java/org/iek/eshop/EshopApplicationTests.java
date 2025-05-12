package org.iek.eshop;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.iek.eshop.businessLogicLayer.dtos.CityDto;
import org.iek.eshop.businessLogicLayer.services.CityService;
import org.iek.eshop.domainLayer.enities.City;
import org.iek.eshop.domainLayer.enities.Product;
import org.iek.eshop.domainLayer.repositories.CitiesCrudRepository;
import org.iek.eshop.domainLayer.repositories.CityRepository;
import org.iek.eshop.domainLayer.repositories.ProductsCrudRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EshopApplicationTests {
    @Autowired
    private CityRepository CityRepository;

    @Autowired
    private CitiesCrudRepository citiesCrudRepository;

    @Autowired
    private ProductsCrudRepository productsCrudRepository;

    @Autowired
    private CityService cityService;

    @Test
    void testCitiesRepo(){
    List<City> cities = CityRepository.get();

    Assertions.assertThat(cities.size()).isGreaterThan(0);
    }

    @Test
    void testCitiesCrudRepo(){
        List<City> cities = Lists
                .newArrayList(citiesCrudRepository.findAll());
        Assertions.assertThat(cities.size()).isNotNegative();
        Assertions.assertThat(cities.size()).isGreaterThan(0);
    }

    @Test
    void testProductsCrudRepo(){
        List<Product> products = Lists
                .newArrayList(productsCrudRepository.findAll());
        Assertions.assertThat(products.size()).isNotNegative();
        Assertions.assertThat(products.size()).isGreaterThan(0);
    }

    @Test
    void testCityService(){
        Throwable t = null;
        try {
            CityDto dto = new CityDto();
            cityService.createCity(dto);
        }
        catch (Throwable x){
            t = x;
        }
        Assertions.assertThat(t).isNotNull();
    }

}
