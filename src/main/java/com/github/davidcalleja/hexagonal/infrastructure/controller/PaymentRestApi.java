package com.github.davidcalleja.hexagonal.infrastructure.controller;

import com.github.davidcalleja.hexagonal.domain.port.primary.PaymentFeesUseCase;
import com.github.davidcalleja.hexagonal.infrastructure.adapter.PaymentDomainToPaymentDTO;
import com.github.davidcalleja.hexagonal.infrastructure.controller.entity.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentRestApi {
    private final PaymentFeesUseCase paymentFeesUseCase;
    private final PaymentDomainToPaymentDTO paymentDomainToPaymentDTO;

    @Autowired
    public PaymentRestApi(
            final PaymentFeesUseCase paymentFeesUseCase,
            final PaymentDomainToPaymentDTO paymentDomainToPaymentDTO
    ) {
        this.paymentFeesUseCase = paymentFeesUseCase;
        this.paymentDomainToPaymentDTO = paymentDomainToPaymentDTO;
    }

    @PostMapping(value = "/total")
    public PaymentDTO calculateTotal(@RequestBody final PaymentDTO payment) {
        var domainConversion = paymentDomainToPaymentDTO.toDomain(payment);
        var feesResult = paymentFeesUseCase.applyFees(domainConversion);
        var rappelResult = paymentFeesUseCase.applyFees(feesResult);
        return paymentDomainToPaymentDTO.toDto(rappelResult);
    }
}
