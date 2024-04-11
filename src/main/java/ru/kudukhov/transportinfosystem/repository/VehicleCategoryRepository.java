package ru.kudukhov.transportinfosystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kudukhov.transportinfosystem.entity.VehicleCategory;

public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Long> {
}
