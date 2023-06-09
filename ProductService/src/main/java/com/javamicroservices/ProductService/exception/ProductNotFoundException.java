package com.javamicroservices.ProductService.exception;

import lombok.Data;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Data
public class ProductNotFoundException extends RuntimeException{
    private String errorCode;

    public ProductNotFoundException(String message, String errorCode){
        // initializes the message field of the exception
        super(message);
        this.errorCode = errorCode;
    }
}
