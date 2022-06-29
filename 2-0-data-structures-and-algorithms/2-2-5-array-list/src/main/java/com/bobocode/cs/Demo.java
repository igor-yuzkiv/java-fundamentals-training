package com.bobocode.cs;

import java.util.Arrays;

public class Demo {
    public static class Runner {

        private ArrayList<Integer> init() {
            ArrayList<Integer> arrayList = new ArrayList<>(6);

            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }

            return arrayList;
        }

        public void run() {
            ArrayList<Integer> arrayList = init();
            System.out.println(Arrays.toString(arrayList.getElements()));

            //arrayList.add(2, 123);
            //System.out.println(Arrays.toString(arrayList.getElements()));

            arrayList.remove(2);
            System.out.println(Arrays.toString(arrayList.getElements()));
        }

    }


    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.run();
    }


}
