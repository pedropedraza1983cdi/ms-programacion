package com.nttdata.terpel.msprogramacion.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "plantas")
public class Plantas {

    @Id
    private Long id;
    private String codigo;
    private String queue;
    private String endpoint;
    private boolean status;
    private String user;
    private String password;
}
