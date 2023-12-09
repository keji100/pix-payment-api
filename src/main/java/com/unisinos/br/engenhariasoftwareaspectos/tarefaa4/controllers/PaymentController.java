package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.controllers;

import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities.PaymentRequest;
import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities.PaymentResponse;
import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<PaymentResponse> generatePayment(@RequestBody PaymentRequest request) {
        return new ResponseEntity<>(this.service.generatePayment(request), HttpStatus.OK);
    }

    @GetMapping("/Payment")
    public ResponseEntity payment(@RequestParam String uuid){
        return new ResponseEntity<>(this.service.payment(uuid), HttpStatus.OK);
    }

    @GetMapping(value = "/Dispatch", produces = MediaType.APPLICATION_JSON_VALUE)
    public void dispatch(){
        System.out.println("Despachado");
        //return new ResponseEntity<>(this.service.dispatch(uuid), HttpStatus.OK);
    }

    @GetMapping("/CancelPayment")
    public ResponseEntity cancelPayment(@RequestParam String uuid){
        return new ResponseEntity<>(this.service.cancelPayment(uuid), HttpStatus.OK);
    }

}
