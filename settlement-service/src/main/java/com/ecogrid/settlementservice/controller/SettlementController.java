package com.ecogrid.settlementservice.controller;

import com.ecogrid.settlementservice.model.SettlementRecord;
import com.ecogrid.settlementservice.repository.SettlementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/settlement")
public class SettlementController {

    private final SettlementRepository repository;

    public SettlementController(SettlementRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ledger")
    public List<SettlementRecord> getLedger() {
        return repository.findAll();
    }

    @PostMapping("/clear")
    public ResponseEntity<SettlementRecord> clearTransaction(@RequestBody SettlementRecord record) {
        record.setSettledAt(LocalDateTime.now());
        // Simple mock cryptographic transaction hash generation
        record.setTransactionHash("0x" + UUID.randomUUID().toString().replace("-", ""));
        SettlementRecord saved = repository.save(record);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}