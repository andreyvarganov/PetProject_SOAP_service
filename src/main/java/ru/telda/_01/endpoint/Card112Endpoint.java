package ru.telda._01.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.telda._01.integration.Card112;
import ru.telda._01.integration.Card112Response;
import ru.telda._01.service.Card112Service;

@Endpoint
public class Card112Endpoint {

    private final String NAMESPACE = "http://www.telda.ru/01/integration";

    @Autowired
    private Card112Service service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "Card112")
    @ResponsePayload
    public Card112Response getCardStatus(@RequestPayload Card112 request){
        return service.checkCard(request);
    }

}
