package com.bobocode.cs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class Tree<T extends Comparable<T>> {
    public static class Node<T> {

        @Getter
        private final T value;

        @Getter
        @Setter
        private Node<T> previousParent;

        @Setter
        @Getter
        private Node<T> leftParent;

        @Setter
        @Getter
        private Node<T> rightParent;

        public Node(T value) {
            this.value = value;
        }

        public static <T> Node<T> valueOf(T value) {
            return new Node<>(value);
        }
    }

    Node<T> root;

    @Getter
    private int size = 0;

    public Tree() {
        root = null;
    }

    public boolean insert(T value) {
        if (root == null) {
            root = Node.valueOf(value);
            incrementSize();
            return true;
        }

        Node<T> current = root;
        Node<T> previous = null;

        while (true) {
            if (value.compareTo(current.getValue()) < 0) {
                if (current.getLeftParent() == null) {
                    current.setLeftParent(Node.valueOf(value));
                    current.setPreviousParent(previous);

                    incrementSize();
                    return true;
                } else {
                    previous = current;
                    current = current.getLeftParent();
                }
            } else if (value.compareTo(current.getValue()) > 0) {
                if (current.getRightParent() == null) {
                    current.setRightParent(Node.valueOf(value));
                    current.setPreviousParent(previous);
                    incrementSize();
                    return true;
                } else {
                    previous = current;
                    current = current.getRightParent();
                }
            } else {
                return false;
            }
        }
    }

    public Node<T> findNodeByValue(T value) {
        if (value == null) {
            throw new NullPointerException();
        }

        Node<T> current = root;
        while (true) {
            if (current == null) {
                return null;
            }

            if (value.equals(current.getValue())) {
                return current;
            } else if (value.compareTo(current.getValue()) < 0) {
                current = current.getLeftParent();
            } else if (value.compareTo(current.getValue()) > 0) {
                current = current.getRightParent();
            } else {
                return null;
            }
        }
    }

    public void removeByValue(T value) {
        Node<T> forRemove = findNodeByValue(value);
        Node<T> previous = forRemove.getPreviousParent();

        System.out.println("F: " + forRemove.getValue());
        System.out.println("P: " + previous.getValue());
    }

    public boolean contains(T value) {
        return findNodeByValue(value) != null;
    }

    private void incrementSize() {
        size++;
    }


}
