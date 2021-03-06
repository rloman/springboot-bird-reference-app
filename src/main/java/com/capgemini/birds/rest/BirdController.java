package com.capgemini.birds.rest;

import com.capgemini.birds.examstuff.component.MyOwnComponent;
import com.capgemini.birds.model.Bird;
import com.capgemini.birds.persistence.BirdRepository;
import com.capgemini.birds.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/birds")
public class BirdController {

    @Autowired
    private BirdService birdService;

    @Autowired
    private Bird rachid;

    @Autowired
    private String companyName;


    @PostMapping
    public ResponseEntity<Bird> create(@RequestBody Bird newBird) {

        newBird.setCompanyName(this.companyName);

        this.birdService.save(newBird);

//        this.birdService.save(this.rachid);

        return new ResponseEntity<Bird>(newBird, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Bird>> list() {

        return new ResponseEntity<Iterable<Bird>>(this.birdService.findAll(),
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Bird> findById(@PathVariable long id) {

        Optional<Bird> result = this.birdService.findById(id);

		// example
        Bird birdWithNameShana = this.birdService.findByName("Shana");

        if (result.isPresent()) {
            return new ResponseEntity<Bird>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Bird> updateById(@PathVariable long id, @RequestBody Bird update) {

        Optional<Bird> possibleVictim = this.birdService.findById(id);

        if (possibleVictim.isPresent()) {
            Bird victim = possibleVictim.get();

            victim.setAge(update.getAge());
            victim.setName(update.getName());
            victim.setSerialNumber(update.getSerialNumber());

            victim = this.birdService.save(victim);

            return new ResponseEntity<Bird>(this.birdService.save(victim),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<Bird>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        this.birdService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}