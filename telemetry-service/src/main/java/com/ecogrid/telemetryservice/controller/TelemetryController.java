package com.ecogrid.telemetryservice.controller;

import com.ecogrid.telemetryservice.model.MeterReading;
import com.ecogrid.telemetryservice.repository.MeterReadingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {

    private final MeterReadingRepository repository;

    public TelemetryController(MeterReadingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MeterReading> getAllReadings() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<MeterReading> recordReading(@RequestBody MeterReading reading) {
        if (reading.getTimestamp() == null) {
            reading.setTimestamp(LocalDateTime.now());
        }
        MeterReading saved = repository.save(reading);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}