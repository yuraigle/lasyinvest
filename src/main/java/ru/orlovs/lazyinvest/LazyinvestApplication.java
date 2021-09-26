package ru.orlovs.lazyinvest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LazyinvestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LazyinvestApplication.class, args);
    }

}
