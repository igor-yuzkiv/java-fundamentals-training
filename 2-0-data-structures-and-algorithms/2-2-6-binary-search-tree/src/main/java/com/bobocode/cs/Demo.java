package com.bobocode.cs;

import java.util.concurrent.ThreadLocalRandom;

public class Demo {

    public static void main(String[] args) {
        int limit = 10_000_000;

        RecursiveBinarySearchTree<Integer> collection = new RecursiveBinarySearchTree<>();
        for (int i = 0; i < limit; i++) {
            int value = ThreadLocalRandom.current().nextInt(limit);
            collection.insert(value);
        }


        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            int value = ThreadLocalRandom.current().nextInt(limit);
            System.out.println("contains(" + value + ") - " + collection.contains(value) + " nanoTime - " + ((System.nanoTime() - start) / 1000));
        }
    }

}
