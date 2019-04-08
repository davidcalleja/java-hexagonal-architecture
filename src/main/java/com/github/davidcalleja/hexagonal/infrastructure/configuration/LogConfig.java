package com.github.davidcalleja.hexagonal.infrastructure.configuration;

import com.github.davidcalleja.hexagonal.domain.port.primary.PaymentFeesUseCase;
import com.github.davidcalleja.hexagonal.domain.port.primary.RappelDiscountUseCase;
import com.github.davidcalleja.hexagonal.domain.port.secondary.Log;
import com.github.davidcalleja.hexagonal.infrastructure.log.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {

    @Bean(value = "logRappelDiscountUseCase")
    public Log logRappelDiscountUseCase() {
        var logger = org.slf4j.LoggerFactory.getLogger(RappelDiscountUseCase.class);
        return generateLogger(logger);
    }

    @Bean(value = "logPaymentFeesUseCase")
    public Log logPaymentFeesUseCase() {
        var logger = org.slf4j.LoggerFactory.getLogger(PaymentFeesUseCase.class);
        return generateLogger(logger);
    }

    private Logger generateLogger(final org.slf4j.Logger logger) {
        return Logger.builder()
                .logger(logger)
                .build();
    }
}
