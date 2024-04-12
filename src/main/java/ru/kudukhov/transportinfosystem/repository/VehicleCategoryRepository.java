package ru.kudukhov.transportinfosystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kudukhov.transportinfosystem.entity.VehicleCategory;

import java.util.List;

@Repository
public interface VehicleCategoryRepository extends JpaRepository<VehicleCategory, Long> {
    List<VehicleCategory> findByNameContainingIgnoreCase(String name);
}
