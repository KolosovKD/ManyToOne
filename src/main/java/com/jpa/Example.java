package com.jpa;


import com.jpa.entity.Lifeboat;
import com.jpa.entity.Ship;
import com.jpa.repository.LifeboatRepository;
import com.jpa.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class Example {

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private LifeboatRepository lifeboatRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Example.class, args);
        context.getBean(Example.class).demo();
    }

    public void demo() {
        addAndSaveSeparately();
        printFleet("separate save");
        addNewBoatToExistingShip(shipRepository.findAll().stream().findFirst().get());
        printFleet("add lifeboat");
        addAndSaveTogether();
        printFleet("save together");

        System.out.println("=========================");
    }

    private void addAndSaveSeparately() {
        Ship ship = new Ship("Queen Mary", "Frigate");
        shipRepository.save(ship);

        Lifeboat lifeboat = new Lifeboat(ship, 1L, 20L);
        lifeboatRepository.save(lifeboat);
    }

    private void addNewBoatToExistingShip(Ship ship) {
        Lifeboat lifeboat2 = new Lifeboat(2L, 20L);
        ship.addLifeboat(lifeboat2);

        shipRepository.save(ship);
    }

    private void addAndSaveTogether() {
        Ship ship2 = new Ship("Saint Antonina", "Caravel");
        ship2.addLifeboat(new Lifeboat(1L, 40L));
        ship2.addLifeboat(new Lifeboat(2L, 40L));
        ship2.addLifeboat(new Lifeboat(3L, 10L));
        ship2.addLifeboat(new Lifeboat(4L, 10L));

        shipRepository.save(ship2);
    }

    private void printFleet(String header) {
        System.out.println("=".repeat(20 - header.length()).concat(header).toUpperCase());
        System.out.println("SHIPS:");
        shipRepository.findAll().forEach(System.out::println);
        System.out.println("LIFEBOATS:");
        lifeboatRepository.findAll().forEach(System.out::println);
    }

}
