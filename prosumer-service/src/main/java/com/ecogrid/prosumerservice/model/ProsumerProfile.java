package com.ecogrid.prosumerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProsumerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String energyType;
    private double surplusCapacityKw;
    private String locationGridZone;

    public ProsumerProfile() {}

    public ProsumerProfile(String name, String energyType, double surplusCapacityKw, String locationGridZone) {
        this.name = name;
        this.energyType = energyType;
        this.surplusCapacityKw = surplusCapacityKw;
        this.locationGridZone = locationGridZone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEnergyType() { return energyType; }
    public void setEnergyType(String energyType) { this.energyType = energyType; }
    public double getSurplusCapacityKw() { return surplusCapacityKw; }
    public void setSurplusCapacityKw(double surplusCapacityKw) { this.surplusCapacityKw = surplusCapacityKw; }
    public String getLocationGridZone() { return locationGridZone; }
    public void setLocationGridZone(String locationGridZone) { this.locationGridZone = locationGridZone; }
}