package com.example.ordermanagement.controller;

import com.example.ordermanagement.entity.Product;
import com.example.ordermanagement.model.ProductModel;
import com.example.ordermanagement.model.ProductStockRequest;
import com.example.ordermanagement.service.StockManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/product-stock")
public class StockManagementController {

    @Autowired
    private StockManagementService stockManagementService;

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.getProductById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody ProductModel product) {
        return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.saveProduct(product));
    }

    @PutMapping("/remove")
    public ResponseEntity<Product> updateProductStock(@RequestBody ProductStockRequest stockRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(stockManagementService.updateProductStock(stockRequest));
    }

}
