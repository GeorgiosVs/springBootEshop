package org.iek.eshop.domainLayer.enities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @Column(name = "id")
    public int id;
    public String name;

    public City(){

    }
}
