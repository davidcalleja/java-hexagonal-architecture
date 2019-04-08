package com.github.davidcalleja.hexagonal.infrastructure.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity(name = "fee")
@Document(collection = "Fee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeeEntity {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type")
    private PaymentTypeEntity paymentType;
    private Integer percentage;
}