package com.javamicroservices.PaymentService.service;

import com.javamicroservices.PaymentService.model.PaymentRequest;
import com.javamicroservices.PaymentService.model.PaymentResponse;
import org.springframework.data.jpa.repository.Query;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(long orderId);
}
