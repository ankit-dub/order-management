package com.example.ordermanagement.service;

import com.example.ordermanagement.entity.Warehouse;
import com.example.ordermanagement.model.WareHouseModel;
import com.example.ordermanagement.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WarehouseService {

    @Autowired
    private WarehouseRepository repository;

    public Warehouse createWarehouse(WareHouseModel model) {
        return repository.save(Warehouse.builder().name(model.getName()).description(model.getDescription()).build());
    }

    public List<Warehouse> getWarehouses() {
        return repository.findAll();
    }

    public Warehouse fetchWarehouseById(Long id) {
        return repository.findById(id).get();
    }

}
