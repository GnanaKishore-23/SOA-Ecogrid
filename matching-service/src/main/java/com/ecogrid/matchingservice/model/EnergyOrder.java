package com.ecogrid.matchingservice.model;

import jakarta.persistence.*;

@Entity
public class EnergyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sellerId;
    private Long buyerId;
    private double energyKwh;
    private double pricePerKwh;
    private String status; // CREATED, MATCHED, CANCELLED

    public EnergyOrder() {}

    public EnergyOrder(Long sellerId, double energyKwh, double pricePerKwh, String status) {
        this.sellerId = sellerId;
        this.energyKwh = energyKwh;
        this.pricePerKwh = pricePerKwh;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getSellerId() { return sellerId; }
    public void setSellerId(Long sellerId) { this.sellerId = sellerId; }
    public Long getBuyerId() { return buyerId; }
    public void setBuyerId(Long buyerId) { this.buyerId = buyerId; }
    public double getEnergyKwh() { return energyKwh; }
    public void setEnergyKwh(double energyKwh) { this.energyKwh = energyKwh; }
    public double getPricePerKwh() { return pricePerKwh; }
    public void setPricePerKwh(double pricePerKwh) { this.pricePerKwh = pricePerKwh; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}