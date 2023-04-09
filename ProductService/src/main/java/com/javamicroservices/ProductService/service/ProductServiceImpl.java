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

        // model -> entity
        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

        // saving to database
        productRepository.save(product);
        log.info("Product "+ product.getProductName()+ " with id: " + product.getProductId() + " is created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long id) {
        log.info("Fetching the product with id: {}", id);

        // finding the product with exception handling
        Product product =  productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("No such product with given id exists", "NOT_FOUND"));
        ProductResponse productResponse = new ProductResponse();

        // entity -> model
        // for BeanUtils.copyProperties -> variable names should be same
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reducing Quantity {} for Product Id: {}", quantity, productId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product Not found with given ID", "NOT_FOUND"));
        if(product.getQuantity() < quantity){
            throw new ProductNotFoundException("Not enough Products available for given quantity",
                   "INSUFFICIENT_QUANTITY");
        }
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product Quantity Updated Successfully");
    }
}
