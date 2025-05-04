package com.tracklink.www.service;

import com.tracklink.www.dto.VehicleDto;
import com.tracklink.www.model.Vehicle;
import com.tracklink.www.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService (VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicle () {
        return this.vehicleRepository.findAll();
    }

    public Vehicle getVehicleById (Long id) {
        return this.vehicleRepository.getVehicleById(id).orElse(null);
    }

    public Vehicle createVehicle (VehicleDto vehicleDto) {
        Vehicle newVehicle = new Vehicle(vehicleDto.getLongitude(), vehicleDto.getLatitude(), vehicleDto.getPrice());
        return this.vehicleRepository.save(newVehicle);
    }

    public Vehicle updateVehicleById (Long id, VehicleDto vehicleDto) {
        Vehicle vehicle = getVehicleById(id);
        if (vehicle != null) {
            vehicle.setLongitude(vehicleDto.getLongitude());
            vehicle.setLatitude(vehicleDto.getLatitude());
            vehicle.setPrice(vehicleDto.getPrice());

            return this.vehicleRepository.save(vehicle);
        }
        return null;
    }

    public boolean deleteVehicleById (Long id) {
        Vehicle vehicle = getVehicleById(id);
        if (vehicle != null) {
            this.vehicleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
