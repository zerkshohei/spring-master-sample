package com.zerk.spring.memo.rabbitmq.tut1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitAmqpTutorialsApplication {
    public static void main(String[] args)  {
        SpringApplication.run(RabbitAmqpTutorialsApplication.class, args);
    }
}