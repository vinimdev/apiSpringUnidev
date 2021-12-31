package com.example.criandoapidozero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CriandoapidozeroApplication {

    public static void main(String[] args) {
        SpringApplication.run(CriandoapidozeroApplication.class, args);
    }

}
