package com.bobocode.cs;

import lombok.Getter;
import lombok.Setter;

//TODO: java balanced binary tree
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

    public boolean removeByValue(T value) {
        Node<T> forRemove = findNodeByValue(value);

        if (forRemove == null) {
            return false;
        }

        if (forRemove == root) {
            root = null;
            size = 0;
            return true;
        }

        Node<T> previous = forRemove.getPreviousParent();
        boolean isLeft = (previous.getValue().compareTo(forRemove.getValue()) > 0);

        if (forRemove.getLeftParent() == null && forRemove.getRightParent() == null) {
            if (isLeft) {
                previous.setLeftParent(null);
            } else {
                previous.setRightParent(null);
            }
        } else if (forRemove.getLeftParent() == null) {
            if (isLeft) {
                previous.setLeftParent(forRemove.getRightParent());
            } else {
                previous.setRightParent(forRemove.getRightParent());
            }
        } else if (forRemove.getRightParent() == null) {
            if (isLeft) {
                previous.setLeftParent(forRemove.getLeftParent());
            } else {
                previous.setRightParent(forRemove.getLeftParent());
            }
        } else {
            previous.setLeftParent(forRemove.getLeftParent());
            previous.setRightParent(forRemove.getRightParent());
        }
        size--;

        return  true;
    }

    public boolean contains(T value) {
        return findNodeByValue(value) != null;
    }

    private void incrementSize() {
        size++;
    }


}
