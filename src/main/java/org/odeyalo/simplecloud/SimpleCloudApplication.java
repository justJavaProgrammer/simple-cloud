package org.odeyalo.simplecloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.odeyalo.simplecloud"})
public class SimpleCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleCloudApplication.class, args);

    }
}