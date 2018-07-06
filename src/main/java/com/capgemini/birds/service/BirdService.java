package com.capgemini.birds.service;


import com.capgemini.birds.model.Bird;
import com.capgemini.birds.persistence.BirdRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BirdService {

    @Autowired
    private BirdRepository birdRepository;

    @PostConstruct
    public void addSomeDummyBirdsUsingFaker() {

        Faker faker = new Faker();

        for(int i = 0;i<5;i++) {

            Bird bird = new Bird();
            bird.setName(faker.name().firstName());
            bird.setSerialNumber(faker.number().numberBetween(1,100));
            bird.setAge(faker.number().numberBetween(0, 40));
            bird.setCity(faker.address().city());

            this.birdRepository.save(bird);
        }
    }

    @Transactional
    public Bird save(Bird b) {

        this.birdRepository.save(b);

        return b;
    }

    public Iterable<Bird> findAll() {

        return this.birdRepository.findAll();
    }

    public Optional<Bird> findById(long id) {

        return this.birdRepository.findById(id);
    }

    public Bird findByName(String name) {

        return this.birdRepository.findByName(name);
    }

    @Transactional
    public void deleteById(long id) {
        this.birdRepository.deleteById(id);
    }
}
