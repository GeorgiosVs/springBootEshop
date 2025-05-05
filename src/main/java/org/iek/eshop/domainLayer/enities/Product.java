package org.iek.eshop.domainLayer.enities;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private long id;
    private String title;
    private String description;
    private double price;

    //@Column(name = "categoryId")
    //private long categoryId;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private ProductCategory category;

}