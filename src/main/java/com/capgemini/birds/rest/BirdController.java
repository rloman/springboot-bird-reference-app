package com.capgemini.birds.rest;

import com.capgemini.birds.model.Bird;
import com.capgemini.birds.persistence.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/birds")
public class BirdController {

    @Autowired
    private BirdRepository birdRepository;


    @PostMapping
    public ResponseEntity<Bird> create(@RequestBody Bird newBird) {

        this.birdRepository.save(newBird);

        return new ResponseEntity<Bird>(newBird, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Bird>> list() {
        return new ResponseEntity<Iterable<Bird>>(this.birdRepository.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Bird> findById(@PathVariable long id) {

        Optional<Bird> result = this.birdRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<Bird>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Bird> updateById(@PathVariable long id, @RequestBody Bird update) {

        Optional<Bird> possibleVictim = this.birdRepository.findById(id);

        if (possibleVictim.isPresent()) {
            Bird victim = possibleVictim.get();

            victim.setAge(update.getAge());
            victim.setName(update.getName());
            victim.setSerialNumber(update.getSerialNumber());

            victim = this.birdRepository.save(victim);

            return new ResponseEntity<Bird>(this.birdRepository.save(victim),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<Bird>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        this.birdRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}