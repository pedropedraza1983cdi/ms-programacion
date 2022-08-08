package com.nttdata.terpel.msprogramacion.procesos.validation;

import com.nttdata.terpel.msprogramacion.model.exceptions.CustomValidationException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import static com.nttdata.terpel.msprogramacion.model.constant.Constantes.*;

@Component
public class ValidateInputsProcessor {


    public void process(String origin) {
        validateStringWithoutSize(HEADER_ORIGIN, origin);
    }

    @SneakyThrows
    private void validateStringWithoutSize(String headerName, String value) {
        if (value == null || value.isEmpty()) {
            throw new CustomValidationException(MESSAGE_HEADER + headerName + MESSAGE_REQUIRED);
        }
    }

}
