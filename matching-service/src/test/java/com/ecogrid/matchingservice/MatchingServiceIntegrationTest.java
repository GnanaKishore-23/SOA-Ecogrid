package com.ecogrid.matchingservice;

import com.ecogrid.matchingservice.model.EnergyOrder;
import com.ecogrid.matchingservice.repository.EnergyOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class MatchingServiceIntegrationTest {

    @Autowired
    private EnergyOrderRepository repository;

    @Test
    public void testOrderCreationAndMatchingFlow() {
        // Step 1: Save new energy order
        EnergyOrder order = new EnergyOrder(101L, 15.0, 0.20, "CREATED");
        EnergyOrder savedOrder = repository.save(order);

        assertNotNull(savedOrder.getId());
        assertEquals("CREATED", savedOrder.getStatus());

        // Step 2: Match order with buyer
        savedOrder.setBuyerId(202L);
        savedOrder.setStatus("MATCHED");
        EnergyOrder updatedOrder = repository.save(savedOrder);

        assertEquals(202L, updatedOrder.getBuyerId());
        assertEquals("MATCHED", updatedOrder.getStatus());
    }
}