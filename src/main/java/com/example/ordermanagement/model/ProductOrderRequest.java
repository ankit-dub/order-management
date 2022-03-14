package com.example.ordermanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class ProductOrderRequest {

    @NotNull
    @Min(100000)
    @Max(999999)
    private Long productId;
    @NotNull
    @DecimalMax(value = "9999.999")
    private Double quantity;
    @NotNull
    @DecimalMax(value = "9999.999")
    private Double pricePerUnit;
    @NotNull
    @Future
    private LocalDate deliveryDate;
    @NotNull
    @Future
    private LocalDate expiryDate;
    @NotNull
    @Past
    private LocalDate manufactureDate;
    @NotNull
    @Min(100000)
    @Max(999999)
    private Long distributorId;

}
