/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    private ListNode copyList(ListNode head) {
        if (head == null) return null;
        
        ListNode newHead = new ListNode(head.val); 
        ListNode currentNew = newHead;
        ListNode currentOld = head.next;
        
        while (currentOld != null) {
            currentNew.next = new ListNode(currentOld.val);
            currentNew = currentNew.next;
            currentOld = currentOld.next;
        }
        
        return newHead;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode first = head.next;

        ListNode second = reverseList(copyList(head));

        ListNode current = head;

        for (int i = 0; i < length - 1; ++i) {
            if (i % 2 == 0) {
                current.next = second;
                second = second.next;
            } else {
                current.next = first;
                first = first.next;
            }
            current = current.next;
        }
        current.next = null;
    }
}
