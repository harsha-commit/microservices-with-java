package com.javamicroservices.OrderService.service;

import com.javamicroservices.OrderService.model.OrderRequest;
import com.javamicroservices.OrderService.model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
    OrderResponse getOrderDetails(long orderId);
}
