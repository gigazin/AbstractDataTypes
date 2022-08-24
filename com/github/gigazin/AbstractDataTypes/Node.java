package AbstractDataTypes;

class Node<T> {
    private Node<T> next;
    private T info;

    Node(T info) {
        this.info = info;
    }

    Node<T> getNext() {
        return this.next;
    }

    void setNext(Node<T> newNext) {
        this.next = newNext;
    }

    T getInfo() {
        return this.info;
    }

    void setInfo(T newInfo) {
        this.info = newInfo;
    }
}
