package com.eelok.phoneFactory.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Phone> phones;

    public long getId() {
        return id;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
