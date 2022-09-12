package com.github.navee.ssmanager;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UDPTest {
    static EchoClient client;
    static EchoServer echoServer;

    @BeforeAll
    public static void setup() throws SocketException, UnknownHostException {
        echoServer = new EchoServer(8888);
        echoServer.start();
        client = new EchoClient("localhost", 8888);
    }

    @Test
    public void whenCanSendAndReceivePacket_thenCorrect() throws IOException {
        String echo = client.sendEcho("hello server");
        assertEquals("hello server", echo);
        echo = client.sendEcho("server is working");
        assertFalse(echo.equals("hello server"));
    }

    @AfterAll
    public static void stop() {
        echoServer.stop();
    }
}