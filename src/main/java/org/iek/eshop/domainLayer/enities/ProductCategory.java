package org.iek.eshop.domainLayer.enities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productcategories")
public class ProductCategory {
    @Id
    public int id;
    public String name;
}
