package com.example.ordermanagement.service;

import com.example.ordermanagement.entity.Product;
import com.example.ordermanagement.entity.Warehouse;
import com.example.ordermanagement.model.ProductModel;
import com.example.ordermanagement.model.ProductStockRequest;
import com.example.ordermanagement.repository.ProductRepository;
import com.example.ordermanagement.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockManagementService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private WarehouseRepository warehouseRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public Product saveProduct(ProductModel model) {
        Optional<Product> fetchedProduct = productRepository.findByName(model.getName());
        if(fetchedProduct.isPresent()) {
            fetchedProduct.get().setQuantityAvailable(fetchedProduct.get().getQuantityAvailable() + model.getQuantityAvailable());
            return productRepository.save(fetchedProduct.get());
        }
        Optional<Warehouse> wh = warehouseRepository.findById(model.getWarehouseId());
        return productRepository.save(Product.builder().name(model.getName()).description(model.getDescription()).quantityUnit(model.getQuantityUnit()).quantityAvailable(model.getQuantityAvailable()).warehouse(wh.get()).build());
    }

    public Product updateProductStock(ProductStockRequest stock) {
        Product fetchedProduct = productRepository.findById(stock.getProductId()).orElseThrow(() -> new RuntimeException());
        fetchedProduct.setQuantityAvailable(fetchedProduct.getQuantityAvailable() - stock.getQuantity());
        return productRepository.save(fetchedProduct);
    }

}
