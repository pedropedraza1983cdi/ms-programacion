package com.nttdata.terpel.msprogramacion.procesos.validation;

import com.nttdata.terpel.msprogramacion.model.PlantaDto;
import org.springframework.stereotype.Component;

@Component
public class ValidacionPlantas {
    public String buildListPlantsError(PlantaDto plantaDto, String listPlantsError) {
        String listPlants = listPlantsError;
        if (listPlants.isEmpty()) {
            listPlants = "";
        } else {
            listPlants = listPlants.concat(", ").concat(plantaDto.getQueue());
        }
        return listPlants;
    }
}
