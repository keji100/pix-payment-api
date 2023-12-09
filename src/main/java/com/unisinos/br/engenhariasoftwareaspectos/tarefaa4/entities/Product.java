package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private BigDecimal value;

}
