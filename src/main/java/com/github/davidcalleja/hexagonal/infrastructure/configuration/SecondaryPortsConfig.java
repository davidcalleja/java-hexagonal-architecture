package com.github.davidcalleja.hexagonal.infrastructure.configuration;

import com.github.davidcalleja.hexagonal.domain.port.secondary.FeesRepository;
import com.github.davidcalleja.hexagonal.infrastructure.adapter.FeeDomainToFeeEntity;
import com.github.davidcalleja.hexagonal.infrastructure.repository.FeesJPARepository;
import com.github.davidcalleja.hexagonal.infrastructure.repository.FeesMongoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.persistence.EntityManager;

@Configuration
public class SecondaryPortsConfig {

    @Bean
    @Profile("mongo")
    @Qualifier("feesRepository")
    public FeesRepository feesRepositoryMongo(
            final MongoTemplate mongoTemplate,
            final FeeDomainToFeeEntity feeDomainToFeeEntity
    ) {
        return FeesMongoRepository.builder()
                .mongoTemplate(mongoTemplate)
                .feeDomainToFeeEntity(feeDomainToFeeEntity)
                .build();
    }

    @Bean
    @Profile("sql")
    @Qualifier("feesRepository")
    public FeesRepository feesRepositorySql(
            final EntityManager entityManager,
            final FeeDomainToFeeEntity feeDomainToFeeEntity
    ) {
        return FeesJPARepository.builder()
                .entityManager(entityManager)
                .feeDomainToFeeEntity(feeDomainToFeeEntity)
                .build();
    }
}
