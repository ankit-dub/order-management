package com.example.ordermanagement.controller;

import com.example.ordermanagement.entity.Distributor;
import com.example.ordermanagement.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/distributor")
public class DistributorController {

    @Autowired
    private DistributorService service;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Distributor> addDistributor(@Valid @RequestBody Distributor distributor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addDistributor(distributor));
    }

    @GetMapping
    public ResponseEntity<List<Distributor>> fetchAllDistributors() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getDistributors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Distributor> fetchDistributorById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getDistributorById(id));
    }

}
