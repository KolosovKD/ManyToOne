package com.jpa.entity;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class LifeboatId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_id")
    private Ship ship;
    private Long number;

    public LifeboatId() {
    }

    public LifeboatId(Long number) {
        this.number = number;
    }

    public LifeboatId(Ship ship, Long number) {
        this.ship = ship;
        this.number = number;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    @Override
    public String toString() {
        return "LifeboatId{" +
                "ship=" + ship.getName() +
                ", number=" + number +
                '}';
    }
}
