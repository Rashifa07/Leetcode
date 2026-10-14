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
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node pointing to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode current = dummy;
        
        // Traverse the list
        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node with the target value
                current.next = current.next.next;
            } else {
                // Move forward if no match
                current = current.next;
            }
        }
        
        // Return the new head (skipping the dummy node)
        return dummy.next;
    }
}