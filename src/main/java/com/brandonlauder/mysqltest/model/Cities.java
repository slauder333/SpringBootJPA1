package com.brandonlauder.mysqltest.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "city")
public class Cities {

    @Id
    @GeneratedValue
    @Column(name = "city_id")
    private Integer id;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "city")
    private Set<Addresses> addresses = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Addresses> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Addresses> addresses) {
        this.addresses = addresses;
    }
}
