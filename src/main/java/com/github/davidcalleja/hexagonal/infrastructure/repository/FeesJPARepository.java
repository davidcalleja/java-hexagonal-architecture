package com.github.davidcalleja.hexagonal.infrastructure.repository;

import com.github.davidcalleja.hexagonal.domain.entity.Fee;
import com.github.davidcalleja.hexagonal.domain.entity.PaymentType;
import com.github.davidcalleja.hexagonal.domain.port.secondary.FeesRepository;
import com.github.davidcalleja.hexagonal.infrastructure.adapter.FeeDomainToFeeEntity;
import com.github.davidcalleja.hexagonal.infrastructure.repository.entity.FeeEntity;
import com.github.davidcalleja.hexagonal.infrastructure.repository.entity.PaymentTypeEntity;
import lombok.Builder;

import javax.persistence.EntityManager;
import java.util.Optional;

@Builder
public class FeesJPARepository implements FeesRepository {
    private final EntityManager entityManager;
    private final FeeDomainToFeeEntity feeDomainToFeeEntity;

    @Override
    public Optional<Fee> getFee(PaymentType paymentType) {
        var result = entityManager.find(FeeEntity.class, PaymentTypeEntity.valueOf(paymentType.toString()));
        return Optional.ofNullable(feeDomainToFeeEntity.toDomain(result));
    }
}
