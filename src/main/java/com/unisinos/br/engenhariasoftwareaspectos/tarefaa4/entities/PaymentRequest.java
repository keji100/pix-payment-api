package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PaymentRequest implements Serializable {
    private String paymentType;
    private String product;
    private BigDecimal amount;
}
