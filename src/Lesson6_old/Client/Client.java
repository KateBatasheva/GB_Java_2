package Lesson6_old.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
   private final static String IP_ADDRESS = "localhost";
    private final static int PORT = 8189;


    public static void main(String[] args) {
            try (Socket socket = new Socket(IP_ADDRESS, PORT)) {
                System.out.println("client on");
                try (DataInputStream inputmes = new DataInputStream(socket.getInputStream());
                     DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                     Scanner scanner = new Scanner(System.in);) {
                    new Thread(() -> {
                        try {
                            while (true) {
                                String string = scanner.nextLine();
                                    if (!string.trim().isEmpty()) {
                                        out.writeUTF(string);
                                    }
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }).start();
                    while (true) {
                        String str = inputmes.readUTF();
                        if (str.equals(".end")) {
                            System.out.println("завершено соединение");
                            out.writeUTF(".end");
                            break;
                        }
                        System.out.println(str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

