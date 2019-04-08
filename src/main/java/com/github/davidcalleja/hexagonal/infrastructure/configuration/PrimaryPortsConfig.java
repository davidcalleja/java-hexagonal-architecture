package com.github.davidcalleja.hexagonal.infrastructure.configuration;

import com.github.davidcalleja.hexagonal.domain.port.primary.PaymentFeesUseCase;
import com.github.davidcalleja.hexagonal.domain.port.primary.RappelDiscountUseCase;
import com.github.davidcalleja.hexagonal.domain.port.secondary.FeesRepository;
import com.github.davidcalleja.hexagonal.domain.port.secondary.Log;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class PrimaryPortsConfig {

    @Bean
    public PaymentFeesUseCase paymentFeesUseCase(
            final FeesRepository feesRepository,
            @Qualifier(value = "logPaymentFeesUseCase") final Log log
    ) {
        return PaymentFeesUseCase.builder()
                .feesRepository(feesRepository)
                .log(log)
                .build();
    }

    @Bean
    public RappelDiscountUseCase rappelDiscountUseCase(@Qualifier(value = "logRappelDiscountUseCase") final Log log) {
        return RappelDiscountUseCase.builder()
                .log(log)
                .build();
    }
}
