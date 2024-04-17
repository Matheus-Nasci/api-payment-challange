package com.api.apipaymentchallenge.service;

import com.api.apipaymentchallenge.dto.UsuarioCadastroDto;
import com.api.apipaymentchallenge.interfaces.UsuarioService;
import com.api.apipaymentchallenge.mapper.UsuarioMapper;
import com.api.apipaymentchallenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository _usuarioRepository;
    private final UsuarioMapper _usuarioMapper;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this._usuarioRepository = usuarioRepository;
        this._usuarioMapper = usuarioMapper;
    }

    @Override
    public void cadastrar(UsuarioCadastroDto usuarioCadastro) {
        var existeUsuario = this.UsuarioExiste(usuarioCadastro.getEmail(), usuarioCadastro.getDocumento());
        if (existeUsuario) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ja cadastrado");
        }
        var usuario = this._usuarioMapper.mapUsuarioCadastroDtoToUsuario(usuarioCadastro);
        this._usuarioRepository.save(usuario);
    }

    public Boolean UsuarioExiste(String documento, String email) {
        var usuarioBanco =  this._usuarioRepository.findByEmailOrDocumento(documento, email);
        if (usuarioBanco.isPresent()){
            return true;
        }
        return false;
    }
}
