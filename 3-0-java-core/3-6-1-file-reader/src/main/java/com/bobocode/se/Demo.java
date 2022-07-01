package com.bobocode.se;

public class Demo {
    public static void main(String[] args) {
        String content = FileReaders.readWholeFile("lines.txt");
        System.out.println(content);
    }
}
