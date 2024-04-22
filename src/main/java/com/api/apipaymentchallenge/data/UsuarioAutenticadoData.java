package com.api.apipaymentchallenge.data;

import lombok.Data;

@Data
public class UsuarioAutenticadoData {
    private Long id;
    private String token;
    private String nomeCompleto;
}
