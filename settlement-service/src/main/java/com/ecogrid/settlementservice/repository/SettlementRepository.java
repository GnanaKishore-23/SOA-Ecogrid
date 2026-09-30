package com.ecogrid.settlementservice.repository;

import com.ecogrid.settlementservice.model.SettlementRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementRepository extends JpaRepository<SettlementRecord, Long> {
}