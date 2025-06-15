package org.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;

public class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            int select = selector.select();
            if (select == 0) continue;
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey selectionKey : selectionKeys) {
                handel(selectionKey);
            }
            selectionKeys.clear();
        }
    }

    public static void handel(SelectionKey selectionKey) throws IOException {
        Scanner scanner = new Scanner(System.in);
        if (selectionKey.isConnectable()) {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            if (socketChannel.isConnectionPending()) {
                socketChannel.finishConnect();
                System.out.println("已完成連線");
            }
            socketChannel.configureBlocking(false);
            socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);
            new Thread(() -> {
                while(true){
                    System.out.println("需要離開請輸入88");
                    System.out.print("請輸入:");
                    String message = scanner.nextLine();
                    if("88".equals(message)) break;
                    ByteBuffer buffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
                    try {
                        socketChannel.write(buffer);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        } else if (selectionKey.isReadable()) {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int len = socketChannel.read(byteBuffer);
            if (len != -1) {
                System.out.println(new String(byteBuffer.array(), 0, len));
            }
        }
    }
}