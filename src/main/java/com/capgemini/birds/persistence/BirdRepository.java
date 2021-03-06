package com.capgemini.birds.persistence;

import com.capgemini.birds.model.Bird;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BirdRepository extends CrudRepository<Bird, Long> {


    Bird findByName(String birdName);

    Iterable<Bird> findAllByOrderByNameAsc();

    // the attributes
    Iterable<Bird> findAllByNameAndAge(String voornaam, int leeftijd);

    Iterable<Bird> findAllByIdOrderByName(Iterable<Long> ids);

}


/*



   Iterable<Bird> findAllByOrderByStateAscNameAsc();

   Iterable<Bird> findByStateAndParentIsNullOrderByDueDateAsc(State state);

   Iterable<Bird> findAllByOrderByDueDateAsc();

   Iterable<Bird> findAllWhereParentIsNullByOrderByDueDateAsc();

   Iterable<Bird> findByParentIsNull();
 */