package com.api.apipaymentchallenge.controller;

import com.api.apipaymentchallenge.dto.CarteiraDto;
import com.api.apipaymentchallenge.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioServiceImpl _usuarioService;

    @Autowired
    public UsuarioController(UsuarioServiceImpl _usuarioService) {
        this._usuarioService = _usuarioService;
    }

    @GetMapping("/consultar-saldo")
        public ResponseEntity<CarteiraDto> GetSaldo() {
        return ResponseEntity.ok(this._usuarioService.getSaldo());
    }
}
