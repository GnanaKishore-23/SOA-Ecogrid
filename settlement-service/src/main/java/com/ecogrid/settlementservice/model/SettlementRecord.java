package com.ecogrid.settlementservice.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SettlementRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    private double totalAmount;
    private String transactionHash;
    private LocalDateTime settledAt;

    public SettlementRecord() {}

    public SettlementRecord(Long orderId, double totalAmount, String transactionHash, LocalDateTime settledAt) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.transactionHash = transactionHash;
        this.settledAt = settledAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getTransactionHash() { return transactionHash; }
    public void setTransactionHash(String transactionHash) { this.transactionHash = transactionHash; }
    public LocalDateTime getSettledAt() { return settledAt; }
    public void setSettledAt(LocalDateTime settledAt) { this.settledAt = settledAt; }
}