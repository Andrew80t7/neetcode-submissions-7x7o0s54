/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> pointers = new HashMap<>();
        Node curr = head;

        while (curr != null) {
            Node copy = new Node(curr.val);
            pointers.put(curr, copy);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            pointers.get(curr).next = pointers.get(curr.next);
            pointers.get(curr).random = pointers.get(curr.random);

            curr = curr.next; 
        }
        return pointers.get(head);
    }
}
