package com.nttdata.terpel.msprogramacion.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.terpel.msprogramacion.model.DespachoDto;
import com.nttdata.terpel.msprogramacion.model.DetDespachoDto;
import com.nttdata.terpel.msprogramacion.model.PlantaDto;
import com.nttdata.terpel.msprogramacion.model.exceptions.TowerException;
import com.nttdata.terpel.msprogramacion.procesos.conexion.ObtenerEstadoPlantasHttpClientService;
import com.nttdata.terpel.msprogramacion.procesos.mapeo.MapeoResponseError;
import com.nttdata.terpel.msprogramacion.procesos.transformations.BuildResponse;
import com.nttdata.terpel.msprogramacion.procesos.validation.LoadPropertiesProcessor;
import com.nttdata.terpel.msprogramacion.procesos.validation.ValidacionPlantas;
import com.nttdata.terpel.msprogramacion.procesos.validation.ValidateInputsProcessor;
import com.nttdata.terpel.msprogramacion.pubsub.InterfazMensajeria1P42;
import com.nttdata.terpel.msprogramacion.service.ProgramacionService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.nttdata.terpel.msprogramacion.model.constant.Constantes.*;

@Service
@Slf4j
public class ProgramacionServiceImpl implements ProgramacionService {

    @Autowired
    private ValidateInputsProcessor validateInputsProcessor;

    @Autowired
    private MapeoResponseError responseError;

    @Autowired
    private LoadPropertiesProcessor loadPropertiesProcessor;

    @Autowired
    private ValidacionPlantas validacionPlantas;

    @Autowired
    private BuildResponse buildResponse;

    @Autowired
    private ObtenerEstadoPlantasHttpClientService obtenerEstadoPlantasHttpClientService;

    @Autowired
    private InterfazMensajeria1P42 interfazMensajeria1P42;

    @SneakyThrows
    @Override
    public ResponseEntity<Object> registrarDespacho(DespachoDto despachoDto, String origin) {
        validateInputsProcessor.process(origin);
        PlantaDto plantaDto = loadPropertiesProcessor.obtenerPlanta("1p42");
        boolean endPointisNotNull = plantaDto.getEndpoint() != null;
        String listPlantsError = "";
        if (plantaDto.isStatus() && endPointisNotNull) {
            boolean isOkPlant = obtenerEstadoPlantasHttpClientService.obtenerEstadoPlants(plantaDto.getEndpoint(), plantaDto.getAuthorization());
            if (isOkPlant) {
                enviarPubSub(objectToStringJson(despachoDto), plantaDto.getQueue());
            } else {
                listPlantsError = validacionPlantas.buildListPlantsError(plantaDto, ERROR_FUNCIONAMIENTO_PLANTA);
            }
        } else {
            throw new TowerException(PLANTA_INACTIVA);
        }
        return ResponseEntity.ok().body(buildResponse.buildResponse(listPlantsError));

    }

    @Override
    public ResponseEntity<Object> actualizarDespacho(DespachoDto despachoDto, String origin) {
        //validateInputsProcessor.process(origin);
        return null;
    }

    @Override
    public ResponseEntity<Object> registrarDetDespacho(DetDespachoDto detDespachoDto, String origin) {
        //validateInputsProcessor.process(origin);
        return null;
    }

    @Override
    public ResponseEntity<Object> actualizarDetDespacho(DetDespachoDto detDespachoDto, String origin) {
        //validateInputsProcessor.process(origin);
        return null;
    }

    @SneakyThrows
    private String objectToStringJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    private void enviarPubSub(String objetoMensaje, String nombreCola) {
        if (nombreCola.equals(QUEUE_1P42))
            interfazMensajeria1P42.sendToPubsub(objetoMensaje);
    }
}