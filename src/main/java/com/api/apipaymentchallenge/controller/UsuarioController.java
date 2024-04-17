package com.api.apipaymentchallenge.controller;

import com.api.apipaymentchallenge.dto.CarteiraDto;
import com.api.apipaymentchallenge.dto.UsuarioCadastroDto;
import com.api.apipaymentchallenge.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioServiceImpl _usuarioService;

    @Autowired
    public UsuarioController(UsuarioServiceImpl _usuarioService) {
        this._usuarioService = _usuarioService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> CadastrarUsuario(@RequestBody UsuarioCadastroDto usuarioCadastroDto) {
        this._usuarioService.cadastrar(usuarioCadastroDto);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/consultar-saldo")
        public ResponseEntity<CarteiraDto> ConsultarSaldoCarteira() {
        return null;
    }
}
