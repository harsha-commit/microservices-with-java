package com.javamicroservices.ProductService.service;

import com.javamicroservices.ProductService.model.ProductRequest;
import com.javamicroservices.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long id);

    void reduceQuantity(long productId, long quantity);
}
