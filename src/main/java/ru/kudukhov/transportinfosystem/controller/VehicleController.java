package ru.kudukhov.transportinfosystem.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kudukhov.transportinfosystem.model.VehicleDTO;
import ru.kudukhov.transportinfosystem.entity.Vehicle;
import ru.kudukhov.transportinfosystem.repository.VehicleRepository;
import ru.kudukhov.transportinfosystem.service.VehicleService;
import ru.kudukhov.transportinfosystem.entity.Vehicle;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/search")
    public ResponseEntity<List<Vehicle>> searchVehicles(
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer startYear,
            @RequestParam(required = false) Integer endYear,
            @RequestParam(required = false) Boolean hasTrailer) {
        List<Vehicle> vehicles = vehicleService.searchVehicles(brand, model, startYear, endYear, hasTrailer);
        return ResponseEntity.ok(vehicles);
    }

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody @Valid VehicleDTO vehicleDTO) {
        Vehicle newVehicle = vehicleService.createVehicle(vehicleDTO);
        return ResponseEntity.ok(newVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody VehicleDTO vehicleDTO) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicleDTO);
        return ResponseEntity.ok(updatedVehicle);
    }


}