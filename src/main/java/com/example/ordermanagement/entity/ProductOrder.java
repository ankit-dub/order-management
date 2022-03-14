package com.example.ordermanagement.entity;

import com.example.ordermanagement.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductOrder {
    @Id
    @SequenceGenerator(name = "product_order_sequence", allocationSize = 1)
    @GeneratedValue(generator = "product_order_sequence", strategy = GenerationType.SEQUENCE)
    private Long productOrderId;

    private Double quantity;
    private Double pricePerUnit;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDate deliveryDate;
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private LocalDate orderedOn;

    @ManyToOne
    @JoinColumn(name = "distributorId", referencedColumnName = "distributorId", foreignKey = @ForeignKey(name = "FK_product_distributor_ID"))
    private Distributor distributor;
    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", foreignKey = @ForeignKey(name = "FK_product_order_ID"))
    private Product product;
}
