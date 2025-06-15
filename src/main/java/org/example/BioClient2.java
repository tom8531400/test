package org.example;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BioClient2 {
    public static void main(String[] args) throws Exception {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8080);
            // 取得輸出流來發送數據
            OutputStream output = socket.getOutputStream();
            String str = "hello bio server";
            output.write(str.getBytes());
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
