package com.github.navee.ssmanager;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UDPTest {
    static EchoClient client;
    static EchoServer echoServer;

    @BeforeAll
    public static void setup() {
        echoServer = new EchoServer();
        echoServer.start(8888);
        client = new EchoClient();
        client.startConnection("localhost", 8888);
    }

    @Test
    public void whenCanSendAndReceivePacket_thenCorrect() {
        String echo = client.sendMessage("hello server");
        assertEquals("hello server", echo);
        echo = client.sendMessage("server is working");
        assertFalse(echo.equals("hello server"));
    }

    //    @AfterAll
    public static void tearDown() {
        client.sendMessage("end");
        client.stopConnection();
        echoServer.shutdown();
    }
}