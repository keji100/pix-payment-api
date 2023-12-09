package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities;


import lombok.Data;

import java.io.Serializable;

@Data
public class PaymentRequest implements Serializable {
    private String paymentType;
    private String product;
    private Double amount;
}
