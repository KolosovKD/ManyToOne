package com.jpa.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ship {

    @Id
    private String name;
    private String type;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.ship", cascade = CascadeType.ALL)
    private Set<Lifeboat> lifeboats = new HashSet<>();

    public Ship() {
    }

    public Ship(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void addLifeboat(Lifeboat lifeboat) {
        lifeboats.add(lifeboat);
        lifeboat.setShip(this);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", lifeboats=" + lifeboats.toString() +
                '}';
    }
}
