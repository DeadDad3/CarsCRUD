package ru.kudukhov.transportinfosystem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kudukhov.transportinfosystem.entity.Vehicle;
import ru.kudukhov.transportinfosystem.repository.VehicleRepository;

import java.util.List;

@Service
@Transactional
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }

    // Другие методы для работы с транспортными средствами
}
