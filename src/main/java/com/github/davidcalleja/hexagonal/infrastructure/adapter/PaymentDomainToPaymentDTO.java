package com.github.davidcalleja.hexagonal.infrastructure.adapter;

import com.github.davidcalleja.hexagonal.domain.entity.Payment;
import com.github.davidcalleja.hexagonal.infrastructure.controller.entity.PaymentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;

@Builder
public class PaymentDomainToPaymentDTO {

    private final ObjectMapper mapper;

    public PaymentDTO toDto(final Payment payment) {
        return mapper.convertValue(payment, PaymentDTO.class);
    }

    public Payment toDomain(final PaymentDTO payment) {
        return mapper.convertValue(payment, Payment.class);
    }
}
