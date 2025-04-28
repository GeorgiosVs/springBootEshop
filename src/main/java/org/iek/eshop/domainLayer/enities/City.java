package org.iek.eshop.domainLayer.enities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "cities")
public class City {
    @Id
    @Column(name = "id")
    public int id;
    public String name;
}
