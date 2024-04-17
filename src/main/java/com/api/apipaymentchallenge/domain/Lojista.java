package com.api.apipaymentchallenge.domain;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("lojista")
public class Lojista extends Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
