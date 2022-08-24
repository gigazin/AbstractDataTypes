package AbstractDataTypes;

public class Deque<T> {
    private Node<T> head;
    private Node<T> tail;
    private int dequeMaximumSize;
    private int dequeActualSize;

    // For double-ended queues that have a maximum capacity.
    public Deque(int size) {
        this.dequeMaximumSize = size;
    }

    // For double-ended queues that are unlimited in capacity.
    public Deque() {
    }

    public boolean isEmpty(){
        return this.head == null && this.tail == null && this.dequeActualSize == 0;
    }

    public boolean isFull() {
        return this.dequeActualSize == this.dequeMaximumSize;
    }

    public void push(T info) {
        Node<T> newNode = new Node<>(info);
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.dequeActualSize++;
    }

    public T pop() {
        T info;
        Node<T> auxiliaryNode;
        auxiliaryNode = this.head;
        this.head = this.head.getNext();
        if (this.head == null) {
            this.tail = null;
        }
        info = auxiliaryNode.getInfo();
        this.dequeActualSize--;
        return info;
    }

    public void inject(T info) {
        Node<T> newNode = new Node<>(info);
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        this.dequeActualSize++;
    }

    public T eject() {
        T info;
        Node<T> auxiliaryNode;
        auxiliaryNode = this.head;
        while (auxiliaryNode != this.tail) {
            if (auxiliaryNode.getNext() == this.tail) {
                break;
            } else {
                auxiliaryNode = auxiliaryNode.getNext();
            }
        }
        info = this.tail.getInfo();
        this.dequeActualSize--;
        if (dequeActualSize == 0) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = auxiliaryNode;
        }
        return info;
    }

}
