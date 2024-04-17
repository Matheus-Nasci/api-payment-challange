package com.api.apipaymentchallenge.service;

import com.api.apipaymentchallenge.dto.CarteiraDto;
import com.api.apipaymentchallenge.interfaces.UsuarioService;
import com.api.apipaymentchallenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public CarteiraDto getSaldo() {
        return null;
    }
}
