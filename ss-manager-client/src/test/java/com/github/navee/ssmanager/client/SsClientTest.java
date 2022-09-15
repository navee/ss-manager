package com.github.navee.ssmanager.client;

import com.github.navee.ssmanager.client.vo.Client;
import com.google.gson.Gson;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

/**
 * @auther navee
 */
public class SsClientTest {

    private static final Gson GSON = new Gson();
    static SsClient ssClient;

    @BeforeClass
    public static void init() throws SocketException, UnknownHostException {
        ssClient = new SsClient("localhost", 6000);
    }

    @Test
    public void ping() {
        Map<String, Long> pong = ssClient.ping();
        System.out.println("pong = " + GSON.toJson(pong));
    }

    @Test
    public void add() {
        ssClient.add(25000, "ssssssssss");
    }

    @Test
    public void list(){
        List<Client> list = ssClient.list();
        System.out.println("list = " + GSON.toJson(list));
    }

    @Test
    public void remove() {
        ssClient.remove(25000);
    }
}