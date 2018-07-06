package com.capgemini.birds.service;


import com.capgemini.birds.model.Bird;
import com.capgemini.birds.persistence.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class BirdService {

    @Autowired
    private BirdRepository birdRepository;

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
