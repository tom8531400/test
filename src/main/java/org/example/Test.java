package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.*;
@Slf4j
public class Test {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        BigDecimal temp = BigDecimal.ZERO;
        TreeMap<BigDecimal, User> users = new TreeMap<BigDecimal, User>();
        List<User> userProbability = new ArrayList<>(Arrays.asList(
                new User(1, "冰箱", new BigDecimal("0.1")), // 10%
                new User(2, "收音機", new BigDecimal("0.1")), // 10%
                new User(3, "安全帽", new BigDecimal("0.2")), // 20%
                new User(4, "機車", new BigDecimal("0.2")), // 20%
                new User(5, "風箏", new BigDecimal("0.4")) // 40%
        ));
        for(User user : userProbability) {
            temp = temp.add(user.getProbability());
            users.put(temp, user);
            System.out.println(temp + "   " + user );
        }
        BigDecimal bigDecimal = users.lastKey();
        System.out.println("bigDecimal = " + bigDecimal);
        double aDouble = random.nextDouble();
        double randNum = aDouble * bigDecimal.doubleValue();
        User value = users.ceilingEntry(BigDecimal.valueOf(randNum)).getValue();
        System.out.println("aDouble: " + aDouble + " \nrandNum: " + randNum + "\nvalue: " + value);
        System.out.println(value);


    }

}

@Data
@AllArgsConstructor
class User {
    private Integer id;
    private String name;
    private BigDecimal probability;

}