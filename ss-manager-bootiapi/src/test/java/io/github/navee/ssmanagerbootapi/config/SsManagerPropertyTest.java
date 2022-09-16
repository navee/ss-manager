package io.github.navee.ssmanagerbootapi.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SsManagerPropertyTest {
    @Autowired
    private SsManagerProperty ssManagerProperty;

    @Test
    void getPort() {
        assertEquals(6000, ssManagerProperty.getPort());
    }
}