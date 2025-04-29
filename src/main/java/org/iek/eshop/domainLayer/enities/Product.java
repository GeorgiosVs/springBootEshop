package org.iek.eshop.domainLayer.enities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity(name = "products")
public class Product {
    @Id
    public int id;
    public String title;
    public String description;
    public double price;
    public int categoryId;
}
