package com.javamicroservices.ProductService.service;

import com.javamicroservices.ProductService.entity.Product;
import com.javamicroservices.ProductService.exception.ProductNotFoundException;
import com.javamicroservices.ProductService.model.ProductRequest;
import com.javamicroservices.ProductService.model.ProductResponse;
import com.javamicroservices.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product...");
        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepository.save(product);
        log.info("Product "+ product.getProductName()+ " with id: " + product.getProductId() + " is created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long id) {
        log.info("Fetching the product with id: {}", id);
        Product product =  productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("No such product with given id exists", "NOT_FOUND"));
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }
}
