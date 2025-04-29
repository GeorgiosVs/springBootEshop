package org.iek.eshop.domainLayer.repositories;

import org.iek.eshop.domainLayer.enities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsCrudRepository extends CrudRepository<Product, Integer> {
    Product findById(int id);
}
