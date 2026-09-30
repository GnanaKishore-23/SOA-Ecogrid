package com.ecogrid.prosumerservice.repository;

import com.ecogrid.prosumerservice.model.ProsumerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProsumerRepository extends JpaRepository<ProsumerProfile, Long> {
}