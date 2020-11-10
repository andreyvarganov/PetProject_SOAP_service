package ru.telda._01.service;

import org.springframework.stereotype.Service;
import org.springframework.ws.config.annotation.EnableWs;
import ru.telda._01.integration.Card112;
import ru.telda._01.integration.Card112Response;
import ru.telda._01.integration.Card112Result;

import javax.xml.ws.BindingType;
import java.math.BigInteger;

@Service
public class Card112Service {

    public Card112Response checkCard(Card112 request) {

        Card112Response response = new Card112Response();
        Card112Result result = new Card112Result();

        if (!request.getCard().getNEmergencyCardId().equals(BigInteger.ZERO)) {
            result.setNEmergencyCardId(request.getCard().getNEmergencyCardId());
            result.setErrorCode(BigInteger.valueOf(0));
        } else {
            result.setNEmergencyCardId(BigInteger.ZERO);
            result.setErrorCode(BigInteger.ONE);
        }

        response.setCard112Result(result);
        return response;
    }

}
