package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Timer;
import java.util.TimerTask;

@Aspect
@Component
public class Aspects {
    RestTemplate restTemplate = new RestTemplate();

    @Before("execution(* com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.controllers.PaymentController.generatePayment(*))")
    public void beforeMethod(){
        String url = "http://localhost:8080/Dispatch";
        restTemplate.getForObject(url, String.class);
    }

//    @Around("execution(* com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.controllers.PaymentController.generatePayment(*))")
//    public void aroundMethod(){
////        Object[] args = JoinPoint.getArgs();
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                String url = "http://localhost:8080/CancelPayment?uuid=1234";
//                restTemplate.getForObject(url, String.class);
//            }
//        }, 1000); //2 min
//    }

    @After("execution(* com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.controllers.PaymentController.payment(*))")
    public void afterMethod(){
        //After Payment
        System.out.println("Product paid and ready to go to client");
    }

}
