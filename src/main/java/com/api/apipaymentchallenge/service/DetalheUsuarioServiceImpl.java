package com.api.apipaymentchallenge.service;

import com.api.apipaymentchallenge.data.DetalheUsuarioData;
import com.api.apipaymentchallenge.domain.Usuario;
import com.api.apipaymentchallenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    private final UsuarioRepository _usuarioRepository;

    @Autowired
    public DetalheUsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        _usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = _usuarioRepository.findByEmail(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }
        return new DetalheUsuarioData(usuario);
    }
}
