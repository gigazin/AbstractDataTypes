package com.github.gigazin.AbstractDataType;

public class Stack<T> {
    private Node<T> top;
    private int stackMaximumCapacity;

    /* For stacks that have a limited capacity. */
    public Stack(int size) {
        this.stackMaximumCapacity = size;
    }

    /* For stacks that are unlimited in capacity. */
    public Stack() {
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public void push(T info) {
        Node<T> newNode = new Node<>(info);
        if (this.isEmpty()) {
            this.top = newNode;
        } else {
            newNode.setNext(this.top);
            this.top = newNode;
        }
    }

    public T pop() {
        T info;
        Node<T> auxiliaryNode;
        auxiliaryNode = this.top;
        this.top = this.top.getNext();
        info = auxiliaryNode.getInfo();
        return info;
    }

    public T top() {
        return this.top.getInfo();
    }

    public boolean isFull() {
        return false;
    }

}
