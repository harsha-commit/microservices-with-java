package com.javamicroservices.OrderService.external.request;

import com.javamicroservices.OrderService.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private long orderId;
    private long orderAmount;
    private String referenceNumber;
    private PaymentMode paymentMode;

}
