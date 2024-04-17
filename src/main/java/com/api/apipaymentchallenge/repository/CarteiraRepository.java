package com.api.apipaymentchallenge.repository;

import com.api.apipaymentchallenge.domain.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
