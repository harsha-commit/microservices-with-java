package com.javamicroservices.ProductService.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Data
public class ProductNotFoundException extends RuntimeException{
    private String errorCode;

    public ProductNotFoundException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
