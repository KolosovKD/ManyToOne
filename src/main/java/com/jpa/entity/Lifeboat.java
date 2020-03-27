package com.jpa.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Lifeboat {


    @EmbeddedId
    private LifeboatId id;
    private Long capacity;

    public Lifeboat() {
    }

    public Lifeboat(Long number, Long capacity) {
        this.id = new LifeboatId(number);
        this.capacity = capacity;
    }

    public Lifeboat(Ship ship, Long number, Long capacity) {
        this.id = new LifeboatId(ship, number);
        this.capacity = capacity;
    }

    public void setShip(Ship ship) {
        id.setShip(ship);
    }

    @Override
    public String toString() {
        return "Lifeboat{" +
                "id=" + id +
                ", capacity=" + capacity +
                '}';
    }
}
