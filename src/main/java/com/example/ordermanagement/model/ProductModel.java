package com.example.ordermanagement.model;

import com.example.ordermanagement.enums.MeasurementUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductModel {
    private String name;
    private String description;
    private Double quantityAvailable;
    private MeasurementUnit quantityUnit;
    private Double price;
    private Long warehouseId;
}
