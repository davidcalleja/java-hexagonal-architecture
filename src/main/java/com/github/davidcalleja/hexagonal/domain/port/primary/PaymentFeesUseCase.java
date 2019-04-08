 package com.github.davidcalleja.hexagonal.domain.port.primary;

 import com.github.davidcalleja.hexagonal.domain.entity.Fee;
 import com.github.davidcalleja.hexagonal.domain.entity.Payment;
 import com.github.davidcalleja.hexagonal.domain.entity.PaymentType;
 import com.github.davidcalleja.hexagonal.domain.port.secondary.FeesRepository;
 import com.github.davidcalleja.hexagonal.domain.port.secondary.Log;

 import java.math.BigDecimal;

public class PaymentFeesUseCase {

    private final FeesRepository feesRepository;
    private final Log log;

    private PaymentFeesUseCase(final FeesRepository feesRepository, final Log log) {
        this.feesRepository = feesRepository;
        this.log = log;
    }

    public static PaymentFeesUseCaseBuilder builder() {
        return new PaymentFeesUseCaseBuilder();
    }

    public Payment applyFees(final Payment payment) {
        var fee = getFee(payment.getPaymentType());
        var result = calculateAmountWithFees(payment.getAmount(), fee.getPercentage());
        log.debug("Initial price is {}. After fee the result is {}", payment.getAmount(), result);
        return payment.toBuilder()
                .amount(result)
                .build();
    }

    private Fee getFee(final PaymentType paymentType) {
        return feesRepository.getFee(paymentType)
                .orElse(Fee.builder()
                        .paymentType(PaymentType.GENERAL)
                        .percentage(0)
                        .build()
                );
    }

    private BigDecimal calculateAmountWithFees(final BigDecimal amount, final int fee) {
        return amount.subtract(amount.multiply(BigDecimal.valueOf((double) fee / 100)));
    }

    public static class PaymentFeesUseCaseBuilder {
        private FeesRepository feesRepository;
        private Log log;

        public PaymentFeesUseCaseBuilder feesRepository(final FeesRepository feesRepository) {
            this.feesRepository = feesRepository;
            return this;
        }

        public PaymentFeesUseCaseBuilder log(final Log log) {
            this.log = log;
            return this;
        }

        public PaymentFeesUseCase build() {
            return new PaymentFeesUseCase(feesRepository, log);
        }
    }
}
