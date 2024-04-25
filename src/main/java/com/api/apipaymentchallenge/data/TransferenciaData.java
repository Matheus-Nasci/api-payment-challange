package com.api.apipaymentchallenge.data;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferenciaData {
    @NotNull
    private Double valor;
    private Long idPagador;
    private Long idBeneficiado;
}