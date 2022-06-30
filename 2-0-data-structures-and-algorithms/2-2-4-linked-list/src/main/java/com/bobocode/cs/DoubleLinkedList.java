package com.bobocode.cs;

import lombok.Getter;
import lombok.Setter;

import static java.util.Objects.requireNonNull;
import static java.util.Objects.isNull;
import static java.util.Objects.checkIndex;

public class DoubleLinkedList<T> implements List<T> {

    public static class Node<T> {

        @Getter
        @Setter
        private T value;


        @Getter
        @Setter
        private Node<T> next;

        @Getter
        @Setter
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }

        public static <T> Node<T> valueOf(T value) {
            return new Node<>(value);
        }
    }

    Node<T> first;

    Node<T> last;

    private int size;

    @Override
    public void add(T element) {
        var newNode = Node.valueOf(requireNonNull(element));

        if (isNull(first)) {
            first = last = newNode;
        } else {
            var previous = last;
            previous.next = newNode;

            last = newNode;
            last.previous = previous;
        }

        size++;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index, size);

        var newNode = Node.valueOf(requireNonNull(element));

        if (isNull(first)) {
            first = last = newNode;
        }
        if (index == size) {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        } else {
            var current = getNodeByIndex(index);

            newNode.previous = current;
            newNode.next = current.next;

            current.next = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T element) {
        checkIndex(index, size);
        var node = getNodeByIndex(index);
        node.setValue(element);
    }

    @Override
    public T get(int index) {
        checkIndex(index, size);
        var node = getNodeByIndex(index);
        return node.getValue();
    }

    @Override
    public T getFirst() {
        return first.getValue();
    }

    @Override
    public T getLast() {
        return last.getValue();
    }

    @Override
    public T remove(int index) {
        checkIndex(index, size);
        var node = getNodeByIndex(index);

        T removedValue = node.getValue();

        node.next.previous = node.previous;
        node.previous.next = node.next;
        size--;

        return removedValue;
    }

    @Override
    public boolean contains(T element) {
        var node = getNodeByValue(requireNonNull(element));
        return node != null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    private Node<T> getNodeByIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private Node<T> getNodeByValue(T value) {
        if (first == null) {
            return null;
        }

        var current = first;
        while (current.next != null) {
            if (current.getValue().equals(value)) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        var current = first;
        int n = 0;

        do {
            if (current == null) {
                break;
            }

            result
                    .append(n)
                    .append(nodeToString(current))
                    .append("\n");

            n++;

            current = current.next;
        }
        while (current.next != null);

        result.append(n).append(nodeToString(last));

        return result.toString();
    }

    private String nodeToString(Node<T> node) {
        StringBuilder result = new StringBuilder();


        result.append(": previous = ");

        if (node.previous != null) {
            result.append(node.previous.getValue());
        }

        result
                .append(" current = ")
                .append(node.getValue())
                .append(" next = ");

        if (node.next != null) {
            result.append(node.next.getValue());
        }

        return result.toString();
    }

}
