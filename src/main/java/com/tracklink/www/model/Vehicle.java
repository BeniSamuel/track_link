package com.tracklink.www.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long longitude;
    private Long latitude;
    private Long price;

    public Vehicle () {}

    public Long getLongitude () { return this.longitude; }
    public Long getLatitude () { return this.latitude; }
    public Long getPrice () { return this.price; }
    public Long getId () { return this.id; }

    public void setLongitude (Long longitude) { this.longitude = longitude; }
    public void setLatitude (Long latitude) { this.latitude = latitude; }
    public void setPrice (Long price) { this.price = price;}
}
