package com.tracklink.www.controller;

import com.tracklink.www.dto.VehicleDto;
import com.tracklink.www.model.Vehicle;
import com.tracklink.www.service.VehicleService;
import com.tracklink.www.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracklink/v1/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController (VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Vehicle>>> getAllVehicle () {
        return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained all vehicle", this.vehicleService.getAllVehicle()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Vehicle>> getVehicleById (@PathVariable Long id) {
        Vehicle vehicle = this.vehicleService.getVehicleById(id);
        if (vehicle != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully obtained vehicle!!!", vehicle));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(true, "Failed to obtained vehicle", null));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Vehicle>> createVehicle (@RequestBody VehicleDto vehicleDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully created vehicle", this.vehicleService.createVehicle(vehicleDto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Vehicle>> updateVehicleById (@PathVariable Long id, @RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle = this.vehicleService.updateVehicleById(id, vehicleDto);
        if (vehicle != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Successfully updated vehicle", vehicle));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Failed to update vehicle", null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Boolean>> deleteVehicleById (@PathVariable Long id) {
        return this.vehicleService.deleteVehicleById(id)
                ? ResponseEntity.ok(new ApiResponse<>(true, "Successfully deleted vehicle", this.vehicleService.deleteVehicleById(id)))
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Failed to delete vehicle", this.vehicleService.deleteVehicleById(id)));

    }
}
