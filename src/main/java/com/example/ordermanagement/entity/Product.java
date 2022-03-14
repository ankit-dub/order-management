package com.example.ordermanagement.entity;

import com.example.ordermanagement.enums.MeasurementUnit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

    @Id
    @SequenceGenerator(name = "product_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "product_id_sequence", strategy = GenerationType.SEQUENCE)
    private Long productId;
    @Column(length = 20, unique = true)
    private String name;
    @Column(length = 100)
    private String description;
    private Double quantityAvailable;
    private Double price;
    @Enumerated(EnumType.STRING)
    private MeasurementUnit quantityUnit;
    @ManyToOne
    @JoinColumn(name = "warehouseId", referencedColumnName = "warehouseId", foreignKey = @ForeignKey(name = "FK_prod_warehouse_ID"))
    private Warehouse warehouse;
}
