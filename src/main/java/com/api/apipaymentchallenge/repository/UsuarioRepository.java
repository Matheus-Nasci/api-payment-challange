package com.api.apipaymentchallenge.repository;

import com.api.apipaymentchallenge.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmailOrDocumento(String email, String documento);

    Optional<Usuario> findByEmail(String login);
}
