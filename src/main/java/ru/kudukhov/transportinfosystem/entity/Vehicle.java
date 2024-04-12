package ru.kudukhov.transportinfosystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private VehicleCategory category;
    private String registrationNumber;
    private String vehicleType;
    private int yearOfManufacture;
    private boolean hasTrailer;
}
