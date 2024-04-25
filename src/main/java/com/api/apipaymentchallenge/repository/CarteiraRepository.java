package com.api.apipaymentchallenge.repository;

import com.api.apipaymentchallenge.domain.Carteira;
import com.api.apipaymentchallenge.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
    Optional<Carteira> findByFkUsuario(Long fkUsuario);
}
