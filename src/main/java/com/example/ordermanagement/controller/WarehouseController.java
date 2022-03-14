package com.example.ordermanagement.controller;

import com.example.ordermanagement.entity.Warehouse;
import com.example.ordermanagement.model.WareHouseModel;
import com.example.ordermanagement.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Warehouse> addWarehouse(@Valid @RequestBody WareHouseModel warehouse) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createWarehouse(warehouse));
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> fetchAllWarehouses() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getWarehouses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> fetchWarehouseById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.fetchWarehouseById(id));
    }

}
