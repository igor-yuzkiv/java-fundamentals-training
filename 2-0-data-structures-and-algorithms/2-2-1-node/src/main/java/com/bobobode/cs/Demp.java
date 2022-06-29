package com.bobobode.cs;

public class Demp {

    public static void main(String[] args) {
        Integer[] ele = {1,2,3};
        Node<Integer> first = Nodes.circleOf(ele);
        System.out.println(first.next.next.next.element);
    }

}
