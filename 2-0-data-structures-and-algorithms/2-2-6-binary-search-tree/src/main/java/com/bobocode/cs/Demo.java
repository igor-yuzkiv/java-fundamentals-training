package com.bobocode.cs;

import java.util.concurrent.ThreadLocalRandom;

public class Demo {

    private static class TestFirst {

        public void run () {
            int limit = 10_000_000;

            long start = System.nanoTime();

            RecursiveBinarySearchTree<Integer> collection = new RecursiveBinarySearchTree<>();
            for (int i = 0; i < limit; i++) {
                int value = ThreadLocalRandom.current().nextInt(limit);
                collection.insert(value);
            }

            for (int i = 0; i < 10; i++) {
                long itemStart = System.nanoTime();
                int value = ThreadLocalRandom.current().nextInt(limit);
                System.out.println("contains(" + value + ") - " + collection.contains(value) + " nanoTime - " + ((System.nanoTime() - itemStart) / 1000));
            }

            System.out.println("Size: " + collection.size());
            System.out.println("Loading Time - " + (((System.nanoTime() - start) / 1000))/1000);
        }

    }

    private static class TestSecond {
        public void run () {
            int limit = 10_000_000;
            long start = System.nanoTime();

            Tree<Integer> tree = new Tree<>();
            for (int i = 0; i < limit; i++) {
                int value = ThreadLocalRandom.current().nextInt(limit);
                tree.insert(value);
            }

            for (int i = 0; i < 10; i++) {
                long itemStart = System.nanoTime();
                int value = ThreadLocalRandom.current().nextInt(limit);
                System.out.println("contains(" + value + ") - " + tree.contains(value) + " nanoTime - " + ((System.nanoTime() - itemStart) / 1000));
            }

            System.out.println("Size: " + tree.getSize());
            System.out.println("Loading Time - " + (((System.nanoTime() - start) / 1000))/1000);
        }

        public void removeTest() {

            Tree<Integer> tree = new Tree<>();
            for (int i = 0; i < 20; i++) {
                tree.insert(i);
            }

            tree.removeByValue(7);

            System.out.println("Size: " + tree.getSize());

        }
    }

    public static void main(String[] args) {

        //TestFirst first = new TestFirst();
        //first.run();


        TestSecond second = new TestSecond();
        second.removeTest();
        //second.run();

    }




}
