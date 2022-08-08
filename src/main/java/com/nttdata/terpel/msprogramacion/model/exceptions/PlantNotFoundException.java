package com.nttdata.terpel.msprogramacion.model.exceptions;

public class PlantNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6695368701814149448L;

    public PlantNotFoundException(String message) {
        super(message);
    }
}
