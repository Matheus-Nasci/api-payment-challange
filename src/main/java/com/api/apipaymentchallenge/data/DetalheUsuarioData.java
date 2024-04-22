package com.api.apipaymentchallenge.data;

import com.api.apipaymentchallenge.domain.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class DetalheUsuarioData implements UserDetails {

    private final Optional<Usuario> usuario;

    public DetalheUsuarioData(Optional<Usuario> usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return usuario.orElse(new Usuario()).getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.orElse(new Usuario()).getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
