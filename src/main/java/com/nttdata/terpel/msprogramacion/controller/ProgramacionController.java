package com.nttdata.terpel.msprogramacion.controller;

import com.nttdata.terpel.msprogramacion.model.DespachoDto;
import com.nttdata.terpel.msprogramacion.model.DetDespachoDto;
import com.nttdata.terpel.msprogramacion.service.ProgramacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.nttdata.terpel.msprogramacion.model.constant.Constantes.HEADER_ORIGIN;

@RestController
@RequestMapping(path = "${service.controller.path}")
public class ProgramacionController {

    @Autowired
    private ProgramacionService service;

    @PostMapping(path = "despacho/registrarDespacho", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> registrarDespacho(@RequestBody DespachoDto despachoDto,
                                                    @RequestHeader(name = HEADER_ORIGIN) String origin) {
        return service.registrarDespacho(despachoDto, origin);
    }

    @PutMapping(path = "despacho/actualizarDespacho", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> actualizarDespacho(@RequestBody DespachoDto despachoDto,
                                                     @RequestHeader(name = HEADER_ORIGIN) String origin) {
        return service.actualizarDespacho(despachoDto, origin);
    }

    @PostMapping(path = "despacho/registrarDetDespacho", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> registrarDetDespacho(@RequestBody DetDespachoDto detDespachoDto,
                                                       @RequestHeader(name = HEADER_ORIGIN) String origin) {
        return service.registrarDetDespacho(detDespachoDto, origin);
    }

    @PutMapping(path = "despacho/actualizarDetDespacho", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> actualizarDetDespacho(@RequestBody DetDespachoDto detDespachoDto,
                                                        @RequestHeader(name = HEADER_ORIGIN) String origin) {
        return service.actualizarDetDespacho(detDespachoDto, origin);
    }
}