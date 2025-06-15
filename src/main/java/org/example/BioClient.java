package org.example;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class BioClient {
    public static void main(String[] args) throws Exception {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8080);
            // 取得輸出流來發送數據
            OutputStream output = socket.getOutputStream();
            Scanner scanner = new Scanner(System.in);
            output.write(scanner.nextLine().getBytes());
            output.flush();
            // 接收服務端返回數據
            InputStream input = socket.getInputStream();
            // 設置byte[]來接收數據
            byte[] bytes = new byte[1024];
            int len = input.read(bytes);
            System.out.println("服務端回復: " + new String(bytes, 0, len));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
