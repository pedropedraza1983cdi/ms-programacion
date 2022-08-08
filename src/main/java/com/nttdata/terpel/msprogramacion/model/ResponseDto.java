package com.nttdata.terpel.msprogramacion.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class ResponseDto {
    private int codigo;
    private String tipo;
    private String mensaje;
    private LocalDate fechaProceso;
}
