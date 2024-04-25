package com.api.apipaymentchallenge.service;

import com.api.apipaymentchallenge.data.*;
import com.api.apipaymentchallenge.domain.Carteira;
import com.api.apipaymentchallenge.domain.Usuario;
import com.api.apipaymentchallenge.interfaces.UsuarioService;
import com.api.apipaymentchallenge.mapper.UsuarioMapper;
import com.api.apipaymentchallenge.repository.CarteiraRepository;
import com.api.apipaymentchallenge.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.*;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Value("${auth.transferencia.url}")
    private String externalUrlAutorizedPayment;

    private final UsuarioRepository _usuarioRepository;
    private final CarteiraRepository _carteiraRepository;
    private final UsuarioMapper _usuarioMapper;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, CarteiraRepository carteiraRepository, UsuarioMapper usuarioMapper) {
        this._usuarioRepository = usuarioRepository;
        _carteiraRepository = carteiraRepository;
        this._usuarioMapper = usuarioMapper;
    }

    @Override
    public void cadastrar(UsuarioCadastroData usuarioCadastroData) {
        var existeUsuario = this.UsuarioExiste(usuarioCadastroData.getEmail(), usuarioCadastroData.getDocumento());
        if (existeUsuario) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ja cadastrado");
        }

        usuarioCadastroData.setSenha(this.bCryptPasswordEncoder()
                .encode(usuarioCadastroData.getSenha()));

        var usuario = this._usuarioMapper.mapUsuarioCadastroDtoToUsuario(usuarioCadastroData);
        this._usuarioRepository.save(usuario);
    }

    public Boolean UsuarioExiste(String documento, String email) {
        var usuarioBanco = this._usuarioRepository.findByEmailOrDocumento(documento, email);
        if (usuarioBanco.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public UsuarioAutenticadoData autenticar(UsuarioLoginData usuarioLoginData) {
        return null;
    }

    @Override
    public void transferirSaldo(TransferenciaData transferenciaData) {
        Optional<Carteira> carteiraBeneficiado = _carteiraRepository.findByFkUsuario(transferenciaData.getIdBeneficiado());
        Optional<Carteira> carteiraPagador = _carteiraRepository.findByFkUsuario(transferenciaData.getIdPagador());

        if (carteiraPagador.isPresent() && carteiraBeneficiado.isPresent()) {
            Optional<Usuario> usuarioBeneficiado = _usuarioRepository.findById(transferenciaData.getIdBeneficiado());
            Optional<Usuario> usuarioPagador = _usuarioRepository.findById(transferenciaData.getIdPagador());
            if (carteiraPagador.get().getSaldo() > 0 && carteiraPagador.get().getSaldo() >= transferenciaData.getValor()) {
                try {
                    URL url = new URL(this.externalUrlAutorizedPayment);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                    Integer responseCode = conn.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        conn.getInputStream();
                    }

                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
