package com.github.davidcalleja.hexagonal.infrastructure.configuration;

import com.github.davidcalleja.hexagonal.infrastructure.adapter.FeeDomainToFeeEntity;
import com.github.davidcalleja.hexagonal.infrastructure.adapter.PaymentDomainToPaymentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {

    @Bean
    public FeeDomainToFeeEntity feeDomainToFeeEntity(final ObjectMapper objectMapper) {
        return FeeDomainToFeeEntity.builder()
                .mapper(objectMapper)
                .build();
    }

    @Bean
    public PaymentDomainToPaymentDTO paymentDomainToPaymentDTO(final ObjectMapper objectMapper) {
        return PaymentDomainToPaymentDTO.builder()
                .mapper(objectMapper)
                .build();
    }
}
