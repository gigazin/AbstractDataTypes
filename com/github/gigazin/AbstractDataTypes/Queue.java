package AbstractDataTypes;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int queueMaximumCapacity;
    private int queueSize;

    // For queues that have a maximum capacity.
    public Queue(int size) {
        this.queueMaximumCapacity = size;
    }

    // For queues that are unlimited in capacity.
    public Queue() {
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null && this.queueSize == 0;
    }

    public boolean isFull() {
        return this.queueSize == this.queueMaximumCapacity;
    }

    public int getQueueSize() {
        return this.queueSize;
    }

    public T head() {
        return this.head.getInfo();
    }

    public T tail() {
        return this.tail.getInfo();
    }

    public void enqueue(T info) {
        Node<T> newNode = new Node<>(info);
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        this.queueSize++;
    }

    public T dequeue() {
        Node<T> auxiliaryNode = this.head;
        T info;
        this.head = this.head.getNext();
        if (this.head == null) {
            this.tail = null;
        }
        info = auxiliaryNode.getInfo();
        this.queueSize--;
        return info;
    }
}
