package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dee {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(new Person(12, "wen1"));
        list.add(new Person(24, "wen2"));
        list.add(new Person(13, "wen3"));

        Map<String, Object> m = new HashMap<>();

    }

}

class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



