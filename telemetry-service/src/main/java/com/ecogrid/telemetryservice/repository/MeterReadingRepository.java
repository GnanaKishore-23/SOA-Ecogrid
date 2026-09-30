package com.ecogrid.telemetryservice.repository;

import com.ecogrid.telemetryservice.model.MeterReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {
}