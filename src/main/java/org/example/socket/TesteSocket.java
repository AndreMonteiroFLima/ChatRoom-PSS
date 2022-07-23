package org.example.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TesteSocket {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3322);
            System.out.println("Servidor iniciado na porta 3322");

            if (!serverSocket.isBound()){
                serverSocket.bind(new InetSocketAddress("192.168.0.1", 0));
            }

            Socket client = serverSocket.accept();
            System.out.println("Cliente Conectado do Ip"+client.getInetAddress());
            Scanner entrada = new Scanner(client.getInputStream());
            while(entrada.hasNextLine()){
                System.out.println(entrada.nextLine());
            }
            entrada.close();
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
