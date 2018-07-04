package com.capgemini.birds.persistence;

import com.capgemini.birds.model.Bird;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BirdRepository extends CrudRepository<Bird, Long>{


}
