package org.example;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) != -1){
                String message = new String(buffer, 0, len);
                System.out.println("message : " + message);
            }
            System.out.println("客戶端段開連接");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
