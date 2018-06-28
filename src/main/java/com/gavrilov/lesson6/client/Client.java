package com.gavrilov.lesson6.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static int port = 3333;
    private static String host = "localhost";

    public static void main(String[] args) throws IOException {
        Socket client = null;
        try {
            client = new Socket(host, port);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));

        String msg;

        while ((msg = stdIn.readLine()) != null) {
            out.println(msg);
            System.out.println(in.readLine());
        }
    }
}

