package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities;


import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class PaymentResponse implements Serializable {

    private UUID id;
    private String pixCopiaECola;
    private Boolean isExpired;

    public PaymentResponse(String pixCopiaECola, Boolean isExpired) {
        id = UUID.randomUUID();
        this.pixCopiaECola = pixCopiaECola;
        this.isExpired = isExpired;
    }

}
