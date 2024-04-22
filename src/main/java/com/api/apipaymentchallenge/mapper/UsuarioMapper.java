package com.api.apipaymentchallenge.mapper;

import com.api.apipaymentchallenge.domain.Usuario;
import com.api.apipaymentchallenge.data.UsuarioCadastroData;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario mapUsuarioCadastroDtoToUsuario(UsuarioCadastroData usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(usuarioDto.getNomeCompleto());
        usuario.setDocumento(usuarioDto.getDocumento());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setSenha(usuarioDto.getSenha());
        return usuario;
    }
}
