package com.tracklink.www.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("bike")
public class Bike extends Vehicle {
}
