package com.example.ordermanagement.service;

import com.example.ordermanagement.entity.Distributor;
import com.example.ordermanagement.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistributorService {

    @Autowired
    private DistributorRepository repository;

    public Distributor addDistributor(Distributor distributor) {
        return repository.save(distributor);
    }

    public List<Distributor> getDistributors() {
        return repository.findAll();
    }

    public Distributor getDistributorById(Long id) {
        return repository.findById(id).get();
    }

}
