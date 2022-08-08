package com.nttdata.terpel.msprogramacion.procesos.mapeo;

import com.nttdata.terpel.msprogramacion.model.ResponseErrorDTO;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MapeoResponseError {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public ResponseErrorDTO process(String codigo, String mensaje, String tipoError) {
        ResponseErrorDTO responseError = new ResponseErrorDTO();
        responseError.setCodigoError(codigo);
        responseError.setMensajeError(mensaje);
        responseError.setTipoError(tipoError);
        responseError.setFechaProceso(dateFormat.format(new Date()));
        return responseError;
    }
}
