package com.bobocode.cs;

public class Demo {
    public static void main (String[] args) {


        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();


        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.toString());

        System.out.println("========================================");

//        list.remove(1);
//
//        System.out.println(list.toString());


        /*Integer[] elements = {1,2,3,4,5};


        LinkedList<Integer> list = LinkedList.of(elements);

        LinkedList.Node<Integer> current = list.getNode(0);
        for (int i = 0; i < list.size(); i ++) {
            if (i == 3) {
                list.add(3, 123);
                current = list.getNode(i);
            }

            System.out.println("current: i("+i+") " + current.element);
            current = current.next;
        }*/
    }
}
