package com.nttdata.terpel.msprogramacion.procesos.validation;

import com.nttdata.terpel.msprogramacion.model.PlantaDto;
import com.nttdata.terpel.msprogramacion.model.exceptions.PlantNotEnabledException;
import com.nttdata.terpel.msprogramacion.model.exceptions.PlantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Component
public class LoadPropertiesProcessor {
    @Autowired
    private PlantaConfig plantConfig;

    public PlantaDto obtenerPlanta(String idPlanta) {
        List<PlantaDto> plants = plantConfig.getPlants();

        Optional<PlantaDto> resultPlant = plants.stream()
                .filter(plant -> plant.getIdPlanta().equals(idPlanta))
                .findFirst();
        PlantaDto plantaDto = resultPlant.orElseThrow(() -> new PlantNotFoundException("La Planta con id=" + idPlanta + " no se encuentra definida."));
        if (!plantaDto.isStatus()) {
            throw new PlantNotEnabledException("la Planta con id=" + idPlanta + " no se encuentra habilitada");
        }
        plantaDto.setAuthorization(generateAuthorization(plantaDto.getUser(), plantaDto.getPassword()));
        return plantaDto;
    }

    private String generateAuthorization(String user, String password) {
        StringBuilder str = new StringBuilder();
        str.append(user);
        str.append(":");
        str.append(password);
        String encodedString = Base64.getEncoder().encodeToString(str.toString().getBytes());
        StringBuilder strHeader = new StringBuilder();
        strHeader.append("Basic ");
        strHeader.append(encodedString);

        return strHeader.toString();
    }
}
