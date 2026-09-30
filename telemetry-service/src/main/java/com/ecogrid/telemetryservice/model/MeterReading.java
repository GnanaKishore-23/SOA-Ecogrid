package com.ecogrid.telemetryservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MeterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long prosumerId;
    private double generatedKwh;
    private double consumedKwh;
    private LocalDateTime timestamp;

    public MeterReading() {}

    public MeterReading(Long prosumerId, double generatedKwh, double consumedKwh, LocalDateTime timestamp) {
        this.prosumerId = prosumerId;
        this.generatedKwh = generatedKwh;
        this.consumedKwh = consumedKwh;
        this.timestamp = timestamp;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProsumerId() { return prosumerId; }
    public void setProsumerId(Long prosumerId) { this.prosumerId = prosumerId; }
    public double getGeneratedKwh() { return generatedKwh; }
    public void setGeneratedKwh(double generatedKwh) { this.generatedKwh = generatedKwh; }
    public double getConsumedKwh() { return consumedKwh; }
    public void setConsumedKwh(double consumedKwh) { this.consumedKwh = consumedKwh; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}