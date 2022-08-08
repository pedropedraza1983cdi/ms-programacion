package com.nttdata.terpel.msprogramacion.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlantaDto {
    private String idPlanta;
    private String queue;
    private String endpoint;
    private boolean status;
    private String user;
    private String password;
    private String authorization;
}
