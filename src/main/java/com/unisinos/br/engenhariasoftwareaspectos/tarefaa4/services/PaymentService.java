package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.services;

import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities.PaymentRequest;
import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities.PaymentResponse;
import com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {
    
    public PaymentResponse generatePayment(PaymentRequest request) {
        var response = PaymentResponse.builder()
                .id(UUID.randomUUID())
                .pixCopiaECola("00020126580014br.gov.bcb.pix0136123e4567-e12b-12d1-a456-426655440000 5204000053039865802BR5913Fulano de Tal6008BRASILIA62070503***63041D3D")
                .isExpired(false)
                .products(List.of(new Product(request.getProduct(), request.getAmount())))
                .build();
        System.out.println(response.toString());
        return response;
    }

    public String payment(String uuid) {
        System.out.println("Pagamento Realizado!");
        return "Pagamento realizado com sucesso";
    }

    public String dispatch(String uuid) {
        return "Pagamento em processamento...";
    }

    public String cancelPayment(String uuid) {
        return "Pagamento cancelado!";
    }

}
