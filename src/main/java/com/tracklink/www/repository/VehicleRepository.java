package com.tracklink.www.repository;

import com.tracklink.www.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Optional<Vehicle> getVehicleById (Long id);
}
