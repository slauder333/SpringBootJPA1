package com.brandonlauder.mysqltest.controllers;

import com.brandonlauder.mysqltest.model.Actors;
import com.brandonlauder.mysqltest.model.Addresses;
import com.brandonlauder.mysqltest.respository.ActorsRepository;
import com.brandonlauder.mysqltest.respository.AddressesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
public class ActorsController {

    @Autowired
    ActorsRepository actorsRepository;

    @Autowired
    AddressesRepository addressesRepository;

    @RequestMapping("/test")
    public Map<String, String> helloWorld(){
            Map<String, String> out = new LinkedHashMap<>();
            out.put("a","1");
    return out;
    }

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

    @RequestMapping("/actors/{name}")
    public List<Actors> getbyname(@PathVariable("name") String name){
        List<Actors> out = actorsRepository.findActorsByFirstName(name);
        return out;
    }

    @PostMapping("/load")
    public List<ApiActors> persist(@RequestBody final Actors actors){
        actorsRepository.save(actors);
        return getAll();
    }

    @RequestMapping("/addresses")
    public List<ApiAddresses> getAllAddresses(){
        List<Addresses> list = (List<Addresses>)addressesRepository.findAll();
        List<ApiAddresses> out = list.stream()
                .map(address -> new ApiAddresses(address.getAddress(), address.getCity().getCity()))
                .collect(Collectors.toList());
        return out;
    }

    public static class ApiActors{
        private String actorFullName;

        public ApiActors() {
        }

        public String getActorFullName() {
            return actorFullName;
        }

        public void setActorFullName(String actorFullName) {
            this.actorFullName = actorFullName;
        }
    }

    public static class ApiAddresses{
        private String address;
        private String city;

        ApiAddresses(String address, String city){
            this.address = address;
            this.city=city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
