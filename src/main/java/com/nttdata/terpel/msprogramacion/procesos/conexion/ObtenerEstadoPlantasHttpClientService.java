package com.nttdata.terpel.msprogramacion.procesos.conexion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class ObtenerEstadoPlantasHttpClientService {
    @Autowired
    private RestTemplate restTemplate;

    public boolean obtenerEstadoPlants(String endPoint, String authorization) {
        boolean isOkPlant = false;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(AUTHORIZATION, authorization);
        HttpEntity<String> request = new HttpEntity<>(headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(endPoint, HttpMethod.GET, request, String.class);
            if (response.getStatusCode().value() == 200) {
                isOkPlant = true;
            }
        } catch (Exception e) {
            return false;
        }
        return isOkPlant;
    }
}
