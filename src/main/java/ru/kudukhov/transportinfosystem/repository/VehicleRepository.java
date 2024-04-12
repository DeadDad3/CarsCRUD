package ru.kudukhov.transportinfosystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kudukhov.transportinfosystem.entity.Vehicle;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByBrandContainingIgnoreCase(String brand);
    List<Vehicle> findByModelContainingIgnoreCase(String model);
    List<Vehicle> findByYearOfManufactureBetween(int startYear, int endYear);
    List<Vehicle> findByHasTrailer(boolean hasTrailer);

    @Query("SELECT v FROM Vehicle v WHERE LOWER(v.brand) LIKE LOWER(:brand) AND LOWER(v.model) LIKE LOWER(:model)")
    List<Vehicle> findByBrandAndModel(String brand, String model);
}