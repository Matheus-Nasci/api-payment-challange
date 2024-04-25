package com.api.apipaymentchallenge.controller;

import com.api.apipaymentchallenge.data.TransferenciaData;
import com.api.apipaymentchallenge.data.UsuarioCadastroData;
import com.api.apipaymentchallenge.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioServiceImpl _usuarioService;

    @Autowired
    public UsuarioController(UsuarioServiceImpl _usuarioService) {
        this._usuarioService = _usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> CadastrarUsuario(@RequestBody UsuarioCadastroData usuarioCadastroData) {
        this._usuarioService.cadastrar(usuarioCadastroData);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/transferir")
    public ResponseEntity<Void> Transferir(@RequestBody TransferenciaData transferencia) {
        this._usuarioService.transferirSaldo(transferencia);
        return ResponseEntity.ok().build();
    }
}
