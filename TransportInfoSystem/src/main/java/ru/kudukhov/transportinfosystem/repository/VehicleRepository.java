package ru.kudukhov.transportinfosystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kudukhov.transportinfosystem.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}