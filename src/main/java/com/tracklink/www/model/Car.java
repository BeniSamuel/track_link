package com.tracklink.www.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("vehicle")
public class Car extends Vehicle {
    private String type;

    public String getType () { return this.type; }
    public void setType (String type) { this.type = type; }
}
