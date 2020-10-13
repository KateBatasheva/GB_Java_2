package Lesson6_old.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static String message;
    static Socket socket;
    final static int Port = 8189;
   static Scanner scanner;

    public static void main (String[] args){

        try (ServerSocket server = new ServerSocket(Port);){
             System.out.println("Server started");
             socket = server.accept();
              System.out.println("Client connected" + socket.getRemoteSocketAddress());
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        message = input.readUTF();
                        if (message.equals(".end")) {
                             System.out.println("Клиент вышел");
                             output.writeUTF(".end");
                            break;
                        }
                        System.out.println("Client: " + message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
            scanner = new Scanner(System.in);
            new Thread(() -> {
                try {
                    while (true) {
                        String string = scanner.nextLine();
                        output.writeUTF("Server" + string);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    }

