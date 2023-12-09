package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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
        System.out.println("[Before] Enviando para despache");
        String url = "http://localhost:8080/Dispatch";
        String bodyParam = "";
        restTemplate.postForObject(url, bodyParam,String.class);
    }

    @Around("execution(* com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.controllers.PaymentController.*(..))")
    public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
//        Object[] args = JoinPoint.getArgs();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            Boolean closed = false;
            @Override
            public void run() {
                if(!closed){
                    System.out.println("[Around] Tempo de compra expirou - cancelando compra");
                    String url = "http://localhost:8080/CancelPayment?uuid=1234";
                    restTemplate.getForObject(url, String.class);
                    closed = true;
                }
            }
        }, 1210000);

        joinPoint.proceed();
    }

    @After("execution(* com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.controllers.PaymentController.payment(*))")
    public void afterMethod(){
        //After Payment
        System.out.println("[After] Product paid and ready to go to client");
    }

}
