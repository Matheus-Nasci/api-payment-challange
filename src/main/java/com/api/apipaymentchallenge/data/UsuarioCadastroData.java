package com.api.apipaymentchallenge.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@Data
public class UsuarioCadastroData {
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
