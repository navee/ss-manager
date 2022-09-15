package com.github.navee.ssmanager.client;

import com.github.navee.ssmanager.client.exceptions.CommunicateException;
import com.github.navee.ssmanager.client.vo.Client;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.TypeUtils;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;

/**
 * @auther navee
 */
public class SsClient implements Closeable {
    private static final String PONG_PREFIX = "stat:";
    private static final Gson GSON = new Gson();
    private static final String LIST_RESP_PREFIX = "received:";
    private UdpClient udpClient;

    public SsClient(String address, int port) throws SocketException, UnknownHostException {
        this.udpClient = new UdpClient(address, port);
    }

    public Map<String, Long> ping() {
        String resp;
        try {
            resp = udpClient.sendEcho("ping");
        } catch (Exception e) {
            throw new CommunicateException(e);
        }
        if (StringUtils.startsWith(resp, PONG_PREFIX)) {
            String pongJson = StringUtils.removeStart(resp, PONG_PREFIX);
            return GSON.fromJson(pongJson, TypeUtils.parameterize(Map.class, String.class, Long.class));
        } else {
            throw new CommunicateException("UNKNOWN RESP:" + resp);
        }
    }

    /**
     * add: {"server_port": 8001, "password":"7cd308cc059"}
     */
    public void add(int port, String password) {
        Map<String, ? extends Serializable> param = Map.of("server_port", port, "password", password);
        try {
            String resp = udpClient.sendEcho("add: " + GSON.toJson(param));
        } catch (IOException e) {
            throw new CommunicateException(e);
        }
    }

    /**
     * {"server_port": 8001}
     */
    public void remove(int port) {
        try {
            Map<String, Integer> param = Map.of("server_port", port);
            udpClient.sendEcho("remove: " + GSON.toJson(param));
        } catch (IOException e) {
            throw new CommunicateException(e);
        }
    }

    public List<Client> list() {
        try {
            String resp = udpClient.sendEcho("list");
            return GSON.fromJson(resp, TypeUtils.parameterize(List.class, Client.class));
        } catch (Exception e) {
            throw new CommunicateException(e);
        }
    }

    @Override
    public void close() throws IOException {
        this.udpClient.close();
    }
}
