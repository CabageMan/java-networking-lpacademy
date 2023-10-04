package com.ironhead;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      InetAddress address = InetAddress.getLocalHost();
      DatagramSocket datagramSocket = new DatagramSocket();

      Scanner scanner = new Scanner(System.in);
      String echoString;

      do {
        System.out.println("Enter string to be echoed: ");
        echoString = scanner.nextLine();

        byte[] bufferOutput = echoString.getBytes();

        DatagramPacket packet = new DatagramPacket(bufferOutput, bufferOutput.length, address, 5000);
        datagramSocket.send(packet);

        // Get response
        byte[] bufferInput = new byte[50];
        packet = new DatagramPacket(bufferInput, bufferInput.length);
        datagramSocket.receive(packet);
        System.out.println(new String(bufferInput, 0, packet.getLength()));
      } while (!echoString.equals("exit"));
    } catch (SocketTimeoutException e) {
      System.out.println("The socket timed out: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("Client error: " + e.getMessage());
    }
  }
}