package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.controllers;

import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities.PaymentResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentManager {

    @PostMapping("/GeneratePayment")
    public void generatePayment(@RequestParam String paymentType,
                                @RequestParam String product,
                                @RequestParam double amount){

    }

    @PostMapping("/Payment")
    public void payment(@RequestParam double amount){

    }

    @PostMapping("/Dispatch")
    public void dispatch(@RequestBody UUID id){

    }

    @PostMapping("/CancelPayment")
    public void cancelPayment(@RequestParam UUID id){

    }
}
