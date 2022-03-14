package com.example.ordermanagement.controller;

import com.example.ordermanagement.model.ProductOrderRequest;
import com.example.ordermanagement.model.ProductOrderResponse;
import com.example.ordermanagement.model.UpdateStatusDto;
import com.example.ordermanagement.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product-order")
public class ProductOrderController {

    @Autowired
    ProductOrderService productOrderService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> createProductOrderRequest(@Valid @RequestBody ProductOrderRequest productOrderRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.productOrderService.createProductOrder(productOrderRequest));
    }

    @GetMapping
    public ResponseEntity<List<ProductOrderResponse>> fetchAllProductOrders() {
        return ResponseEntity.status(HttpStatus.OK).body(this.productOrderService.fetchAllProductOrders());
    }

    @PutMapping
    public ResponseEntity<ProductOrderResponse> updateDeliveryStatus(@Valid @RequestBody UpdateStatusDto updateStatusDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.productOrderService.updateProductOrderDeliveryStatus(updateStatusDto));
    }

    @GetMapping("/{productOrderId}")
    public ResponseEntity<ProductOrderResponse> getProductOrderById(@PathVariable long productOrderId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.productOrderService.fetchProductOrderById(productOrderId));
    }
}
