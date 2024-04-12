package ru.kudukhov.transportinfosystem.model;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Data
public class VehicleDTO {
    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Model is required")
    private String model;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

    @NotBlank(message = "Registration number is required")
    private String registrationNumber;

    @NotBlank(message = "Vehicle type is required")
    private String vehicleType;

    @PastOrPresent(message = "Year of manufacture must be in the past or present")
    private int yearOfManufacture;

    @NotNull(message = "Trailer information is required")
    private Boolean hasTrailer;
}