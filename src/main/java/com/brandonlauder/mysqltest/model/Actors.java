package com.brandonlauder.mysqltest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="actor")
@Setter
@Getter
public class Actors {

    @Id
    @GeneratedValue
    @Column(name = "actor_id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public Actors() {
    }
}
