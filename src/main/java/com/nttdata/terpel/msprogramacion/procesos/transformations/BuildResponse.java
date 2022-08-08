package com.nttdata.terpel.msprogramacion.procesos.transformations;

import com.nttdata.terpel.msprogramacion.model.ResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.nttdata.terpel.msprogramacion.model.constant.Constantes.ERROR_FAIL;
import static com.nttdata.terpel.msprogramacion.model.constant.Constantes.MESSAGE_OK;

@Component
public class BuildResponse {

    public ResponseDto buildResponse(String listPlantsError) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setCodigo(200);
        responseDto.setFechaProceso(LocalDate.now());
        StringBuilder strBuilder = new StringBuilder(MESSAGE_OK);
        if (!listPlantsError.isBlank()) {
            responseDto.setTipo(ERROR_FAIL);
            strBuilder.append(" - Error procesando la solicitud ");
            strBuilder.append(listPlantsError);
        } else {
            responseDto.setTipo(MESSAGE_OK);
        }
        responseDto.setMensaje(strBuilder.toString());
        return responseDto;
    }
}
