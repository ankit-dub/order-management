package com.example.ordermanagement.helper;

import com.example.ordermanagement.entity.Distributor;
import com.example.ordermanagement.entity.Product;
import com.example.ordermanagement.entity.ProductOrder;
import com.example.ordermanagement.enums.OrderStatus;
import com.example.ordermanagement.model.ProductOrderRequest;
import com.example.ordermanagement.model.ProductOrderResponse;

import java.time.LocalDate;

public class ProductOrderMapper {


    public static ProductOrderResponse entityToDto(ProductOrder productOrder) {
        return ProductOrderResponse.builder()
                .productOrderId(productOrder.getProductOrderId())
                .productId(productOrder.getProduct().getProductId())
                .quantity(productOrder.getQuantity())
                .pricePerUnit(productOrder.getPricePerUnit())
                .orderStatus(productOrder.getOrderStatus())
                .deliveryDate(productOrder.getDeliveryDate())
                .manufactureDate(productOrder.getManufactureDate())
                .expiryDate(productOrder.getExpiryDate())
                .orderedOn(productOrder.getOrderedOn())
                .distributorName(productOrder.getDistributor().getName())
                .distributorId(productOrder.getDistributor().getDistributorId())
                .productName(productOrder.getProduct().getName())
                .description(productOrder.getProduct().getDescription())
                .measurementUnit(productOrder.getProduct().getQuantityUnit())
                .warehouse(productOrder.getProduct().getWarehouse())
                .build();
    }


    public static ProductOrder dtoToEntity(ProductOrderRequest request) {
        ProductOrder order = new ProductOrder();
        Distributor distributor = new Distributor();
        distributor.setDistributorId(request.getDistributorId());
        Product product = new Product();
        product.setProductId(request.getProductId());
        order.setProduct(product);
        order.setQuantity(request.getQuantity());
        order.setPricePerUnit(request.getPricePerUnit());
        order.setDeliveryDate(request.getDeliveryDate());
        order.setExpiryDate(request.getExpiryDate());
        order.setManufactureDate(request.getManufactureDate());
        order.setOrderStatus(OrderStatus.PROCESSING);
        order.setDistributor(distributor);
        order.setOrderedOn(LocalDate.now());
        return order;
    }
}
