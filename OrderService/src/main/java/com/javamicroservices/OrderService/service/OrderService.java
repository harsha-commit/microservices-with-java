package com.javamicroservices.OrderService.service;

import com.javamicroservices.OrderService.model.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
