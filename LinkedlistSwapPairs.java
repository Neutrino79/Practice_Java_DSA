package Practice;
/* 
Given a linked list, swap every two adjacent nodes and return its head. 
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:

Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
_______________________________________________________________________________________
practice using java:
*/
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LinkedlistSwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummynode=new ListNode(0);
        
        ListNode left=dummynode;
        ListNode curr=head;
        left.next=curr;
        ListNode right;

        while(curr!=null && curr.next!=null)
        {
            right=curr.next.next;
            left.next=curr.next;
            left.next.next=curr;
            curr.next=right;

            left=curr;
            curr=right;
        }

        head=dummynode.next;
        return head;
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        LinkedlistSwapPairs solution = new LinkedlistSwapPairs();
        ListNode result1 = solution.swapPairs(head1);
        printList(result1); // Output: 2 -> 1 -> 4 -> 3

        // Example 2
        ListNode head2 = null;

        ListNode result2 = solution.swapPairs(head2);
        printList(result2); // Output: (empty list)

        // Example 3
        ListNode head3 = new ListNode(1);

        ListNode result3 = solution.swapPairs(head3);
        printList(result3); // Output: 1
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}