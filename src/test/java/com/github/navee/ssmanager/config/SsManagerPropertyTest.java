package com.github.navee.ssmanager.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SsManagerPropertyTest {
    @Autowired
    private SsManagerProperty ssManagerProperty;

    @Test
    void getPort() {
        assertEquals(6000, ssManagerProperty.getPort());
    }
}