package com.example.aula2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired    
    @Qualifier("nomeAplicacao")
    private String nomeAplicacao;

    @Autowired    
    @Qualifier("versaoAplicacao")
    private String versaoAplicacao;


    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping(value="/")
    public String getMethodName() {
        return nomeAplicacao + " - " + applicationName + " - " + versaoAplicacao;
    }
}
