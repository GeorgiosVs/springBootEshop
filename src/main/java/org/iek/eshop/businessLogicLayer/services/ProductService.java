package org.iek.eshop.businessLogicLayer.services;

import org.iek.eshop.domainLayer.repositories.ProductsCrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductService(ProductsCrudRepository productsCrudRepository) {
    }
}