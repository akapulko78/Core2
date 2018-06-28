package com.gavrilov.lesson6.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int port = 3333;

    public static void main(String[] args) throws IOException {

        class ClientConnection implements Runnable {
            private Socket client;

            ClientConnection(Socket client) {
                this.client = client;
            }

            public void run() {
                BufferedReader in;
                PrintWriter out;
                try {
                    in = new BufferedReader(new InputStreamReader(
                            client.getInputStream()));
                    out = new PrintWriter(client.getOutputStream(), true);
                } catch (IOException e) {
                    System.err.println(e);
                    return;
                }
                String msg;
                try {
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Client says: " + msg);
                        out.println("Сообщение доставлено на сервер");
                    }
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
            System.err.println(e);
            System.exit(1);
        }

        Socket client = null;
        while (true) {
            try {
                System.out.println("Сервер подключен");
                client = server.accept();

            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.err.println(e);
                System.exit(1);
            }
            Thread t = new Thread(new ClientConnection(client));
            t.start();
        }
    }
}
