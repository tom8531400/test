package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class wen {
    public static void main(String[] args) throws IOException {
//        List<User2> users = new ArrayList<>();
//        users.add(new User2("user1", "password1"));
//        users.add(new User2("user2", "password2"));
//        users.add(new User2("user3", "password3"));
//        users.add(new User2("user4", "password4"));
//        users.add(new User2("user5", "password5"));
//
//        User2 user2 = users.stream()
//                .filter(user -> "user4".equals(user.getUserName()))
//                .findFirst()
//                .orElse(null);
//        System.out.println(user2);
//
//        for (User2 user : users) {
//            if ("user3".equals(user.getUserName())) {
//                System.out.println(user);
//            }
//        }
//
//        users.forEach(user -> {
//            if("user1".equals(user.getUserName())) {
//                System.out.println(user);
//            }
//        });
//
//        Map<String, String> maps = users.stream()
//                .collect(Collectors.toMap(User2::getUserName, User2::getPassword));
//        for(Map.Entry<String, String> entry : maps.entrySet()) {
//            if("user2".equals(entry.getKey())){
//                System.out.println(entry);
//            }
//        }
//    }

        // 25506 積蓄
        // 車貸 11459
        // 房貸 10000
        // 信貸 3500
        // 汽車保險 15000
        // 罰單 600
        // 稅金 2000
//        System.out.println(25506 - (11459 + 10000 + 3500 + 15000 + 600 + 2000));
        // 一小時送300$
//        Random random = new Random();
//        int i = random.nextInt(100);
//        System.out.println(i);
//        int i1 = ThreadLocalRandom.current().nextInt();
//        System.out.println(i1);


        int a = 49773; // 薪水
        int a1 = 6000; // 戶頭

//        int a2 = 11230; // 汽車牌照稅 v
//        int a3 = 15200; // 還黃 v
//        int a4 = 3500; // 上月學貸 v
//        int a5 = 1000; // 還D v
//        int a6 = 10000; // 房貸 v
//        int a7 = 11459; // 車貸 v
//        int a8 = 3500; // 信貸 v
//        int a9 = 3500; // 學貸
//        int a10 = 5000; // 家用 v
//        int a11 = 4500; // 卡費 v
//
//        System.out.println((a + a1) - (a2 + a3 + a4 + a5 + a6 + a7 + a8 + a10 + a11));

//
//        Path path = Paths.get("C:/Users/user/Desktop/oom.log");
//        InputStream inputStream = Files.newInputStream(path.toFile().toPath());
//        int len = 0;
//        ByteBuffer buffer = ByteBuffer.allocate(1024);
//        while((len = inputStream.read()) > 0){
//            String s = new String(buffer.array(), 0, len);
//            System.out.println(s);
//        }

    }
}
