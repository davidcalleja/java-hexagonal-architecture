package com.github.davidcalleja.hexagonal.infrastructure.controller.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PaymentDTO implements Serializable {
    private PaymentTypeDTO paymentType;
    private BigDecimal amount;
}