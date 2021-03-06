package com.brandonlauder.mysqltest.respository;

import com.brandonlauder.mysqltest.model.Actors;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorsRepository extends CrudRepository<Actors, Integer>, JpaSpecificationExecutor<Actors> {

    List<Actors> findActorsByFirstName(String name);


}
