package com.github.navee.ssmanager.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@Data
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "ss.manager")
public class SsManagerProperty {
    private int port;
}
