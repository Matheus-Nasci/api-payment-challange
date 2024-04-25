package com.api.apipaymentchallenge.interfaces;

import com.api.apipaymentchallenge.data.TransferenciaData;
import com.api.apipaymentchallenge.data.UsuarioLoginData;
import com.api.apipaymentchallenge.data.UsuarioAutenticadoData;
import com.api.apipaymentchallenge.data.UsuarioCadastroData;

public interface UsuarioService {
    void cadastrar(UsuarioCadastroData usuarioCadastroData);

    UsuarioAutenticadoData autenticar(UsuarioLoginData usuarioLoginData);

    void transferirSaldo(TransferenciaData transferenciaData);
}
