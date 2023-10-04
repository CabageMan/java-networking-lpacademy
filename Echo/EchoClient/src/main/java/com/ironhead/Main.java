package com.ironhead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 5000)) {

      /*
      // Checking for socket time out
      socket.setSoTimeout(5000);
       */

      BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

      Scanner scanner = new Scanner(System.in);
      String echoString;
      String response;
      do {
        System.out.println("Enter string to be echoed: ");
        echoString = scanner.nextLine();

        output.println(echoString);
        if (!echoString.equals("exit")) {
          response = input.readLine();
          System.out.println(response);
        }
      } while (!echoString.equals("exit"));
    } catch (SocketTimeoutException e) {
      System.out.println("The socket timed out: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("Client Error: " + e.getMessage());
    }
  }
}