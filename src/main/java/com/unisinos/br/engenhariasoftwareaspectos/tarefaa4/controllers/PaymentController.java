package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.controllers;

import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities.PaymentRequest;
import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities.PaymentResponse;
import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping(value = "/GeneratePayment")
    public ResponseEntity<PaymentResponse> generatePayment(@RequestBody PaymentRequest request){
        return new ResponseEntity<>(this.service.generatePayment(request), HttpStatus.OK);
    }

    @PostMapping("/Payment")
    public void payment(@RequestParam double amount){

    }

    @PostMapping("/Dispatch")
    public void dispatch(@RequestParam UUID id){

    }

    @PostMapping("/CancelPayment")
    public void cancelPayment(@RequestParam UUID id){

    }
}
