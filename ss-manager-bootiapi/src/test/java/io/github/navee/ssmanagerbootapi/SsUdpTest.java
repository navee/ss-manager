package io.github.navee.ssmanagerbootapi;

import org.junit.jupiter.api.Test;

import java.net.*;

/**
 * @auther raozh
 */
public class SsUdpTest {
    @Test
    public void test() throws Exception {
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(1000);
        ds.connect(InetAddress.getByName("localhost"), 6000); // 连接指定服务器和端口
// 发送:
        byte[] data = "ping".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length);
        ds.send(packet);
// 接收:
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        ds.receive(packet);
        String resp = new String(packet.getData(), packet.getOffset(), packet.getLength());
        System.out.println("resp = " + resp);
        ds.disconnect();
    }
}
