/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
Ref: https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/
 */
class RemoveKthLastInLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    //adding dummy node is the key
        ListNode dummy = new ListNode(0);
        ListNode fast = dummy;
        ListNode slow = dummy;
        dummy.next = head;
        int k = 1;
        while(k<=n+1){
            fast = fast.next;
            k++;
        }
        while(fast !=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

/**
Testcases:
[1] 1
[1,2] 1
[1,2] 2
[1,2,3] 1
[1,2,3] 2
[1,2,3] 3
[1,2,3,4] 2
*/
