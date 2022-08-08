package com.nttdata.terpel.msprogramacion.model.exceptions;

public class PlantNotEnabledException extends RuntimeException {

    private static final long serialVersionUID = 6364717883762763758L;

    public PlantNotEnabledException(String message) {
        super(message);
    }
}
