package ru.kudukhov.transportinfosystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kudukhov.transportinfosystem.entity.Vehicle;
import ru.kudukhov.transportinfosystem.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleService.findAllVehicles();
    }

    // Другие эндпоинты
}
