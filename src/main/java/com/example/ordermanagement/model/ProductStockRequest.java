package com.example.ordermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductStockRequest {

    @NotNull
    private Long productId;

    @NotNull
    private Double quantity;

}
