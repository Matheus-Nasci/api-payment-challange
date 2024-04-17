package com.api.apipaymentchallenge.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Carteira {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double saldo;
}
