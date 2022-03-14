package com.example.ordermanagement.entity;

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
public class Warehouse {

    @Id
    @SequenceGenerator(name = "warehouse_id_sequence", initialValue = 100000, allocationSize = 1)
    @GeneratedValue(generator = "warehouse_id_sequence", strategy = GenerationType.SEQUENCE)
    private Long warehouseId;
    @Column(length = 20)
    private String name;
    @Column(length = 50)
    private String description;

}
