package com.github.davidcalleja.hexagonal.infrastructure.repository;

import com.github.davidcalleja.hexagonal.domain.entity.Fee;
import com.github.davidcalleja.hexagonal.domain.entity.PaymentType;
import com.github.davidcalleja.hexagonal.domain.port.secondary.FeesRepository;
import com.github.davidcalleja.hexagonal.infrastructure.adapter.FeeDomainToFeeEntity;
import com.github.davidcalleja.hexagonal.infrastructure.repository.entity.FeeEntity;
import lombok.Builder;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Optional;

@Builder
public class FeesMongoRepository implements FeesRepository {
    private final MongoTemplate mongoTemplate;
    private final FeeDomainToFeeEntity feeDomainToFeeEntity;

    @Override
    public Optional<Fee> getFee(PaymentType paymentType) {
        return mongoTemplate.find(Query.query(Criteria.where("paymentType").is(paymentType)), FeeEntity.class)
                .stream()
                .findFirst().map(feeDomainToFeeEntity::toDomain);
    }
}
