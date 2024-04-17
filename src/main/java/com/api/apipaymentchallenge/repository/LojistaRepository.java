package com.api.apipaymentchallenge.repository;

import com.api.apipaymentchallenge.domain.Lojista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LojistaRepository extends JpaRepository<Lojista ,Long> {
}
