package com.github.davidcalleja.hexagonal.infrastructure.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.davidcalleja.hexagonal.domain.entity.Fee;
import com.github.davidcalleja.hexagonal.infrastructure.repository.entity.FeeEntity;
import lombok.Builder;

@Builder
public class FeeDomainToFeeEntity {

    private final ObjectMapper mapper;

    public FeeEntity toEntity(final Fee fee) {
        return mapper.convertValue(fee, FeeEntity.class);
    }

    public Fee toDomain(final FeeEntity entity) {
        return mapper.convertValue(entity, Fee.class);
    }
}
