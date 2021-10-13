package com.brandonlauder.mysqltest.resource;

import com.brandonlauder.mysqltest.model.Actors;
import com.brandonlauder.mysqltest.respository.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "rest/actors")
public class ActorsResource {

    @Autowired
    ActorsRepository actorsRepository;

    @GetMapping(value = "/all")
    public List<Actors> getAll(){
        return (List<Actors>) actorsRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Actors> persist(@RequestBody final Actors actors){
        actorsRepository.save(actors);
        return (List<Actors>) actorsRepository.findAll();
    }
}
