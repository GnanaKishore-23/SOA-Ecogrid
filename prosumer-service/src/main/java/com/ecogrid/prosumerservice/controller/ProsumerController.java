package com.ecogrid.prosumerservice.controller;

import com.ecogrid.prosumerservice.model.ProsumerProfile;
import com.ecogrid.prosumerservice.repository.ProsumerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prosumers")
public class ProsumerController {

    private final ProsumerRepository repository;

    public ProsumerController(ProsumerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ProsumerProfile> getAllProsumers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProsumerProfile> getProsumerById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProsumerProfile> createProsumer(@RequestBody ProsumerProfile profile) {
        ProsumerProfile saved = repository.save(profile);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}