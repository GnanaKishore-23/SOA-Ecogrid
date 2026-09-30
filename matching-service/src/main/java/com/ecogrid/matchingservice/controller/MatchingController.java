package com.ecogrid.matchingservice.controller;

import com.ecogrid.matchingservice.model.EnergyOrder;
import com.ecogrid.matchingservice.repository.EnergyOrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matching")
public class MatchingController {

    private final EnergyOrderRepository repository;

    public MatchingController(EnergyOrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EnergyOrder> getAllOrders() {
        return repository.findAll();
    }

    @PostMapping("/order")
    public ResponseEntity<EnergyOrder> createOrder(@RequestBody EnergyOrder order) {
        order.setStatus("CREATED");
        EnergyOrder saved = repository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/order/{orderId}/match")
    public ResponseEntity<EnergyOrder> matchOrder(@PathVariable Long orderId, @RequestParam Long buyerId) {
        return repository.findById(orderId)
                .map(order -> {
                    order.setBuyerId(buyerId);
                    order.setStatus("MATCHED");
                    return ResponseEntity.ok(repository.save(order));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}