package com.github.davidcalleja.hexagonal.domain.port.primary;

import com.github.davidcalleja.hexagonal.domain.entity.Payment;
import com.github.davidcalleja.hexagonal.domain.entity.PaymentType;
import com.github.davidcalleja.hexagonal.domain.port.secondary.Log;

import java.util.List;

public class RappelDiscountUseCase {
    private static final int MINIMAL_VOLUME_RAPPEL = 20;
    private static final int VOLUME_RAPPEL = 3;

    private final Log log;

    private RappelDiscountUseCase(final Log log) {
        this.log = log;
    }

    public static RappelDiscountUseCase.RappelDiscountUseCaseBuilder builder() {
        return new RappelDiscountUseCaseBuilder();
    }

    public int getRappelDiscount(final List<Payment> payments) {
        var volume = payments.stream()
                .filter(payment -> payment.getPaymentType().equals(PaymentType.INTERNAL))
                .count();
        if (volume < MINIMAL_VOLUME_RAPPEL) {
            log.info("No rappel applied");
            return 0;
        }
        log.info("Rappel applied is {}", VOLUME_RAPPEL);
        return VOLUME_RAPPEL;
    }

    public static class RappelDiscountUseCaseBuilder {
        private Log log;

        public RappelDiscountUseCaseBuilder log(final Log log) {
            this.log = log;
            return this;
        }

        public RappelDiscountUseCase build() {
            return new RappelDiscountUseCase(log);
        }
    }
}
