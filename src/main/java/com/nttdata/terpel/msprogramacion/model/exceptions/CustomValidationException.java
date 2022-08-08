package com.nttdata.terpel.msprogramacion.model.exceptions;

public class CustomValidationException extends Exception{

    private static final long serialVersionUID = 1L;

    public CustomValidationException(String message) {
        super(message);
    }
}
