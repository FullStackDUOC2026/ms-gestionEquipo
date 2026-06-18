package com.example.ms_asignaciones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClientEmpleado(){
        return WebClient.builder()
                .baseUrl("https://ms-empleado-production.up.railway.app/api/v1/empleado")
                .build();
    }
    @Bean
    public WebClient webClientEquipo(){
        return WebClient.builder()
                .baseUrl("NO EXISTO")
                .build();
    }
}
