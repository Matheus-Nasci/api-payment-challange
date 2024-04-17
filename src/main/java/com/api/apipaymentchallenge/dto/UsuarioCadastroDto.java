package com.api.apipaymentchallenge.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class UsuarioCadastroDto {
    @NotBlank
    private String nomeCompleto;
    @CPF
    @CNPJ
    @NotBlank
    private String documento;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String senha;
}
