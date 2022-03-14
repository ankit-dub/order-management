package com.example.ordermanagement.service;

import com.example.ordermanagement.entity.ProductOrder;
import com.example.ordermanagement.enums.OrderStatus;
import com.example.ordermanagement.helper.ProductOrderMapper;
import com.example.ordermanagement.model.ProductOrderRequest;
import com.example.ordermanagement.model.ProductOrderResponse;
import com.example.ordermanagement.model.ProductStockRequest;
import com.example.ordermanagement.model.UpdateStatusDto;
import com.example.ordermanagement.repository.ProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductOrderService {

    @Autowired
    private ProductOrderRepository orderRepository;

    @Autowired
    private StockManagementService updateStockService;

    public ProductOrderResponse fetchProductOrderById(long productOrderId) {
        return ProductOrderMapper.entityToDto(this.orderRepository.findById(productOrderId)
                .orElseThrow(() -> new UsernameNotFoundException("productOrderId Not found")));
    }

    public List<ProductOrderResponse> fetchAllProductOrders() {
        return orderRepository.findAll().stream().map(ProductOrderMapper::entityToDto).collect(Collectors.toList());
    }

    public ProductOrderResponse updateProductOrderDeliveryStatus(UpdateStatusDto updateStatusDto) {
        ProductOrder order = orderRepository.findById(updateStatusDto.getOrderId())
                .orElseThrow(() -> new IllegalStateException("Product Order Id Not found"));

        if (order.getOrderStatus().equals(OrderStatus.DELIVERED))
            throw new IllegalStateException("Product already delivered");

        if (order.getOrderStatus().equals(OrderStatus.CANCELLED))
            throw new IllegalStateException("Product delivery was already cancelled");

        if (updateStatusDto.getStatus().equals(OrderStatus.DELIVERED.toString()))
            order.setOrderStatus(OrderStatus.valueOf(updateStatusDto.getStatus()));

        if (updateStatusDto.getStatus().equals(OrderStatus.CANCELLED.toString()))
            order.setOrderStatus(OrderStatus.valueOf(updateStatusDto.getStatus()));

        updateStockService.updateProductStock(new ProductStockRequest(order.getProduct().getProductId(), order.getQuantity()));
        return ProductOrderMapper.entityToDto(this.orderRepository.save(order));
    }

    public Map<String, String> createProductOrder(ProductOrderRequest productOrder) {
//check if product available
        return Collections.singletonMap("productOrderId", this.orderRepository.save(ProductOrderMapper.dtoToEntity(productOrder)).getProductOrderId().toString());
    }

}
