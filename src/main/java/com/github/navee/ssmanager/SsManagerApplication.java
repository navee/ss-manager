package com.github.navee.ssmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SsManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsManagerApplication.class, args);
    }

}
