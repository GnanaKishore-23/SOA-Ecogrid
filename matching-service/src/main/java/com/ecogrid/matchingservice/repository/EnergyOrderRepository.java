package com.ecogrid.matchingservice.repository;

import com.ecogrid.matchingservice.model.EnergyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergyOrderRepository extends JpaRepository<EnergyOrder, Long> {
}