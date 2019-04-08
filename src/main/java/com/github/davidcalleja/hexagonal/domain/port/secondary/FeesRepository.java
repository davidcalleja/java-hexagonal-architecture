package com.github.davidcalleja.hexagonal.domain.port.secondary;

import com.github.davidcalleja.hexagonal.domain.entity.Fee;
import com.github.davidcalleja.hexagonal.domain.entity.PaymentType;

import java.util.Optional;

public interface FeesRepository {

    Optional<Fee> getFee(final PaymentType paymentType);
}
