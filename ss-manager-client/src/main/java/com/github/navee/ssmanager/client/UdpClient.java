package com.github.navee.ssmanager.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.net.*;

public class UdpClient implements Closeable {

    private static final Logger LOG = LoggerFactory.getLogger(UdpClient.class);
    private DatagramSocket socket;
    private InetAddress address;

    public UdpClient(String address, int port) throws SocketException, UnknownHostException {
        this.socket = new DatagramSocket();
        this.address = InetAddress.getByName(address);
        socket.connect(this.address, port);
    }

    String sendEcho(String msg) throws IOException {
        byte[] msgBytes = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(msgBytes, msgBytes.length);
        socket.send(packet);
        byte[] resp = new byte[1024];
        packet = new DatagramPacket(resp, resp.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        LOG.debug("send:{}\treceived:{}", msg, received);
        return received;
    }

    public void close() {
        socket.close();
    }

}