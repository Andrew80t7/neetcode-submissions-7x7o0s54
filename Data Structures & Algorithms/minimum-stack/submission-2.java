class MinStack<T extends Comparable<T>>{

    private class Node {
        T val;
        T min;
        Node next;

        private Node(T val, T min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;


    public MinStack() {
    }

    public void push(T val) {
        if (head == null){
            head = new Node(val, val, null);
        }
        else {
            T currmin = (val.compareTo(head.min) < 0) ? val: head.min;
            head = new Node(val, currmin, head);
        }
    }

    public void pop() {
        if (head != null){
            head = head.next;
        }

    }

    public T top() {
        return (head != null) ? head.val: null;
    }

    public T getMin() {
        return (head != null) ? head.min : null;
    }
}