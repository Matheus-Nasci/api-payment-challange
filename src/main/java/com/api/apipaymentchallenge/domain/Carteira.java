package com.api.apipaymentchallenge.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Carteira {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double saldo;
    private Long fkUsuario;
}