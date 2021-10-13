package com.brandonlauder.mysqltest.controllers;

import com.brandonlauder.mysqltest.model.Actors;
import com.brandonlauder.mysqltest.respository.ActorsRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@Api(tags = {"Actors"}, description = "Actors REST APIs", hidden = false )
@RestController
public class ActorsController {

    @Autowired
    ActorsRepository actorsRepository;

    @ApiOperation(value = "test API", nickname = "testIt")
    @RequestMapping("/test")
    public Map<String, String> helloWorld(){
            Map<String, String> out = new LinkedHashMap<>();
            out.put("a","1");
    return out;
    }

    @ApiOperation(value = "get all Actors API", nickname = "getAllActors")
    @RequestMapping("/actors")
    public List<ApiActors> getAll(){
        Stream<Actors> streamActors = StreamSupport.stream(actorsRepository.findAll().spliterator(), false);
        List<ApiActors> apiOut = streamActors.map(actors -> {
                    ApiActors out = new ApiActors();
                    out.setActorFullName(actors.getFirstName() + " " + actors.getLastName());
                    return out;
                })
                .collect(Collectors.toList());
        return apiOut;
    }

    @ApiOperation(value = "get Actors by first name ", nickname = "getAllActorsByFirstName")
    @RequestMapping("/actors/{name}")
    public List<Actors> getbyname(@PathVariable("name") String name){
        List<Actors> out = actorsRepository.findActorsByFirstName(name);
        return out;
    }

    @ApiOperation(value = "get Actors by first name ", nickname = "getAllActorssearchByFirstName")
    @RequestMapping("/actors/searchFristName/{name}")
    public List<Actors> getserchbyname(@PathVariable("name") String name){
        List<Actors> out = actorsRepository.findActorsByFirstNameContaining(name);
        return out;
    }

    @ApiOperation(value = "add multiple Actors", nickname = "loadActors")
    @PostMapping(value = "/load")
    public List<ApiActors> persist(@RequestBody final Actors actors){
        actorsRepository.save(actors);
        return getAll();
    }

    @Setter
    @Getter
    public static class ApiActors{
        private String actorFullName;
    }
}
