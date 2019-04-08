package com.github.davidcalleja.hexagonal.domain.entity;

import java.math.BigDecimal;

public class Payment {
    private PaymentType paymentType;
    private BigDecimal amount;

    public Payment() {
    }

    private Payment(PaymentType paymentType, BigDecimal amount) {
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public static PaymentBuilder builder() {
        return new PaymentBuilder();
    }

    public PaymentType getPaymentType() {
        return this.paymentType;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public PaymentBuilder toBuilder() {
        return new PaymentBuilder().paymentType(this.paymentType).amount(this.amount);
    }

    public static class PaymentBuilder {
        private PaymentType paymentType;
        private BigDecimal amount;

        PaymentBuilder paymentType(PaymentType paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public PaymentBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Payment build() {
            return new Payment(paymentType, amount);
        }
    }
}
