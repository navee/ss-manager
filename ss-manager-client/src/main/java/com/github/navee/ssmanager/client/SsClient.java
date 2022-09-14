package com.github.navee.ssmanager.client;

import java.io.Closeable;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * @auther raozh
 */
public class SsClient implements Closeable {
    private UdpClient udpClient;

    public SsClient(String address, int port) throws SocketException, UnknownHostException {
        this.udpClient = new UdpClient(address, port);
    }

    public void ping() {

    }

    /**
     * add: {"server_port": 8001, "password":"7cd308cc059"}
     */
    public void add() {

    }

    /**
     * {"server_port": 8001}
     */
    public void remove() {

    }

    /**
     * stat: {"8001":11370}
     */
    public void stat() {

    }

    @Override
    public void close() throws IOException {
        this.udpClient.close();
    }
}
