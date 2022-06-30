package com.bobocode.cs;

public class Demo {

    public static void main(String[] args) {

        HashTable<String, String> table = new HashTable<>();

        table.put("Key1", "value1");
        table.put("kEy1", "value2");
        table.put("key2", "value3");
        table.put("aAaA", "value4");
        table.put("bBbB", "value5");

        System.out.println("====================================");
        System.out.println(table.toString());
    }

}
