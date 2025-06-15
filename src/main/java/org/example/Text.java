package org.example;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Text {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = null;
        FileChannel channel = null;
        ByteBuffer buffer = null;
        try{
            randomAccessFile = new RandomAccessFile("src/wen.txt", "rw");
            channel = randomAccessFile.getChannel();
            buffer = ByteBuffer.allocate(1024);
            String message = "104 is coming";
            buffer.put(message.getBytes());
            buffer.flip();
            channel.write(buffer);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }finally {
            if(randomAccessFile != null) randomAccessFile.close();
            if(channel != null) channel.close();
            if(buffer != null) buffer.clear();
        }
    }
}
