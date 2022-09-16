package io.github.navee.ssmanagerbootapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;

public class EchoClient implements Closeable {

    private static final Logger LOG = LoggerFactory.getLogger(EchoClient.class);
    private DatagramSocket socket;
    private InetAddress address;

    public EchoClient(String address, int port) throws SocketException, UnknownHostException {
        this.socket = new DatagramSocket();
        this.address = InetAddress.getByName(address);
        socket.connect(this.address, port);
    }

    public String sendEcho(String msg) throws IOException {
        byte[] buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.send(packet);
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        LOG.debug("send:{}\treceived:{}", msg, received);
        return received;
    }

    public void close() {
        socket.close();
    }
}