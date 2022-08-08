package com.nttdata.terpel.msprogramacion.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseErrorDTO {
    @JsonProperty("fechaProceso")
    private String fechaProceso;

    @JsonProperty("codigoError")
    private String codigoError;

    @JsonProperty("tipoError")
    private String tipoError;

    @JsonProperty("mensajeError")
    private String mensajeError;
}
