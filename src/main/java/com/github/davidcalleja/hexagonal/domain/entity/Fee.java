package com.github.davidcalleja.hexagonal.domain.entity;

public class Fee {
    private PaymentType paymentType;
    private int percentage;

    public Fee() {
    }

    private Fee(final PaymentType paymentType, final int percentage) {
        this.paymentType = paymentType;
        this.percentage = percentage;
    }

    public static FeeBuilder builder() {
        return new FeeBuilder();
    }

    public PaymentType getPaymentType() {
        return this.paymentType;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public static class FeeBuilder {
        private PaymentType paymentType;
        private int percentage;

        public Fee.FeeBuilder paymentType(final PaymentType paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Fee.FeeBuilder percentage(final int percentage) {
            this.percentage = percentage;
            return this;
        }

        public Fee build() {
            return new Fee(paymentType, percentage);
        }
    }
}
