package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.services;

import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities.PaymentRequest;
import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    
    public PaymentResponse generatePayment(PaymentRequest request) {
        var response = new PaymentResponse("tjsidjoajdisoajda", false);
        return response;
    }
    
}
