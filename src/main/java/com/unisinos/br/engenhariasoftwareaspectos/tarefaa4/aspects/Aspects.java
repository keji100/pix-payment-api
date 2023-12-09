package com.unisinos.br.engenhariasoftwareaspectos.tarefaa4.aspects;

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

    @Before("execution(*com.unisinos.br.engenhariasoftwareaspectos.tarefaa4*)")
    public void beforeMethod(){
        String url = "http://localhost:8080/Dispatch";
        String requestBody = "UUID=";
        restTemplate.postForObject(url, requestBody, String.class);
    }

    @Around("**")
    public void aroundMethod(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String url = "http://localhost:8080/CancelPayment";
                String requestBody = "UUID=";
                restTemplate.postForObject(url, requestBody, String.class);
            }
        }, 120000); //2 min
    }

    @After("**")
    public void afterMethod(){

    }

}
