package com.capgemini.birds.persistence;

import com.capgemini.birds.model.Bird;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class BirdRepository {

    // in real live we would have a real DB here .... like Oracle, MySQL or Postgres


    private static long lastId = 0;

    private Map <Long, Bird> birds = new HashMap<>();  // this you might see as a mock db

    @PostConstruct
    public void addSomeBirdsToGetStarted() {
        for(int i = 0;i<5;i++) {
            Bird bird = new Bird();
            bird.setName("Gerrit "+ i);
            bird.setAge(2*i);

            this.save(bird);
        }
    }

    public void save(Bird newBird) {
        newBird.setId(++lastId);
        this.birds.put(newBird.getId(), newBird);

    }

    public Collection<Bird> findAll() {
        return this.birds.values();
    }

    public Bird findById(long id) {

        Bird found = this.birds.get(id);

        return found;
    }

    public void deleteById(long id) {

        this.birds.remove(id);
    }



    // some method to demo return a sorted based on property list
    public List<Bird> birdsWithAgeLargerThanFour() {
        Collection<Bird> allBirds = this.findAll();
        List<Bird> result = allBirds.stream().filter( bird -> bird.getAge() > 4).collect(Collectors.toList());

        Collections.sort(result, (a,b) -> a.getAge() - b.getAge());

        return result;
    }

    public Bird update(long id, Bird update) {
        Bird victim = this.findById(id);

        victim.setAge(update.getAge());
        victim.setName(update.getName());
        victim.setSerialNumber(update.getSerialNumber());

        return victim;
    }
}
