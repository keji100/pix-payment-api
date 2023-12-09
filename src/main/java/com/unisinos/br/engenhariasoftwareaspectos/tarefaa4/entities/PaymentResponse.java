package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PaymentResponse implements Serializable {

    private UUID id;
    private String pixCopiaECola;
    private Boolean isExpired;
    private List<Product> products;
    private BigDecimal totalValue;

}
