package com.nttdata.terpel.msprogramacion.controller;

import com.nttdata.terpel.msprogramacion.procesos.mapeo.MapeoResponseError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.nttdata.terpel.msprogramacion.model.constant.Constantes.*;

@ControllerAdvice
public class ManejoErroresController extends ResponseEntityExceptionHandler {
    @Autowired
    private MapeoResponseError responseError;

    @ExceptionHandler(HttpClientErrorException.class)
    public final ResponseEntity<Object> errorNoAutorizado(HttpClientErrorException httpClientErrorException) {

        int statusCode = httpClientErrorException.getStatusCode().value();

        if (statusCode == 400) {
            return new ResponseEntity<>(responseError.process(String.valueOf(HttpStatus.BAD_REQUEST.value()), BAD_REQUEST, ERROR_FAIL), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (statusCode == 401) {
            return new ResponseEntity<>(responseError.process(String.valueOf(HttpStatus.UNAUTHORIZED.value()), NO_AUTORIZADO, ERROR_FAIL), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (statusCode == 404) {
            return new ResponseEntity<>(responseError.process(String.valueOf(HttpStatus.NOT_FOUND.value()), ERROR_NOTFOUND, ERROR_FAIL), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(responseError.process(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), httpClientErrorException.getMessage(), ERROR_FAIL), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
