package com.nttdata.terpel.msprogramacion.procesos.validation;

import com.nttdata.terpel.msprogramacion.model.PlantaDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlantaConfig {
    private List<PlantaDto> plants;

    public List<PlantaDto> getPlants() {
        return plants;
    }

    public void setPlants(List<PlantaDto> plants) {
        this.plants = plants;
    }
}
