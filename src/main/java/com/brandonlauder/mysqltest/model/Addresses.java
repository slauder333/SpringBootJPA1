package com.brandonlauder.mysqltest.model;

import javax.persistence.*;


@Entity
@Table(name = "address")
public class Addresses {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private Cities city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }
}
