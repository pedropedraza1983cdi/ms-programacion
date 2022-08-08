package com.nttdata.terpel.msprogramacion.pubsub;


import org.springframework.integration.annotation.MessagingGateway;

import static com.nttdata.terpel.msprogramacion.model.constant.Constantes.TOPICO_1P42;

@MessagingGateway(defaultRequestChannel = TOPICO_1P42)
public interface InterfazMensajeria1P42 {
    void sendToPubsub(String payload);
}
