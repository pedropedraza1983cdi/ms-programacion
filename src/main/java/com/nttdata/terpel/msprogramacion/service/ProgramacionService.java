package com.nttdata.terpel.msprogramacion.service;

import com.nttdata.terpel.msprogramacion.model.DespachoDto;
import com.nttdata.terpel.msprogramacion.model.DetDespachoDto;
import org.springframework.http.ResponseEntity;

public interface ProgramacionService {


    ResponseEntity<Object> registrarDespacho(DespachoDto despachoDto, String origin);

    ResponseEntity<Object> actualizarDespacho(DespachoDto despachoDto, String origin);

    ResponseEntity<Object> registrarDetDespacho(DetDespachoDto detDespachoDto, String origin);

    ResponseEntity<Object> actualizarDetDespacho(DetDespachoDto detDespachoDto, String origin);

}