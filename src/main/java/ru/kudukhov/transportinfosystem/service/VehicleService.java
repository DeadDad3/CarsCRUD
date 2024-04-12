package ru.kudukhov.transportinfosystem.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.kudukhov.transportinfosystem.entity.Vehicle;
import ru.kudukhov.transportinfosystem.repository.VehicleRepository;
import ru.kudukhov.transportinfosystem.repository.VehicleCategoryRepository;
import ru.kudukhov.transportinfosystem.model.VehicleDTO;

import java.util.List;

@Service
@Transactional
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final VehicleCategoryRepository vehicleCategoryRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, VehicleCategoryRepository vehicleCategoryRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleCategoryRepository = vehicleCategoryRepository;
    }

    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle createVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setCategory(vehicleCategoryRepository.findById(vehicleDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found")));
        vehicle.setRegistrationNumber(vehicleDTO.getRegistrationNumber());
        vehicle.setVehicleType(vehicleDTO.getVehicleType());
        vehicle.setYearOfManufacture(vehicleDTO.getYearOfManufacture());
        vehicle.setHasTrailer(vehicleDTO.getHasTrailer());

        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> searchVehicles(String brand, String model, Integer startYear, Integer endYear, Boolean hasTrailer) {
        // Реализуйте фильтрацию и уточнение поиска в зависимости от переданных параметров
        return vehicleRepository.findByBrandAndModel(brand, model); // Это просто пример, реализация может отличаться
    }

    public Vehicle updateVehicle(Long id, VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id " + id));

        vehicle.setBrand(vehicleDTO.getBrand());
        vehicle.setModel(vehicleDTO.getModel());
        vehicle.setYearOfManufacture(vehicleDTO.getYearOfManufacture());
        vehicle.setHasTrailer(vehicleDTO.getHasTrailer());

        return vehicleRepository.save(vehicle);
    }
}