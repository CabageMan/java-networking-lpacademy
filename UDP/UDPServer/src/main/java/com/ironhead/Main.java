package com.ironhead;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {
  public static void main(String[] args) {
    try {
      DatagramSocket socket = new DatagramSocket(5000);

      while (true) {
        // Check is wrapping to threads is needed?!!!
        byte[] bufferInput = new byte[50];
        DatagramPacket packet = new DatagramPacket(bufferInput, bufferInput.length);
        socket.receive(packet);
        String clientString = new String(bufferInput, 0, packet.getLength());
        System.out.println("Text received is: " + clientString);

        // Send response
        String returnString = "Reply from server: " + clientString;
        byte[] bufferOutput = returnString.getBytes();
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        packet = new DatagramPacket(bufferOutput, bufferOutput.length, address, port);
        socket.send(packet);
      }
    } catch (SocketException e) {
      System.out.println("SocketException: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    }
  }
}