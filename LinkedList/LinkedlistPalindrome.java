package Practice;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedlistPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Get the middle node in mid and the node before mid in temp
        ListNode mid = head;
        ListNode end = head;
        while (end != null && end.next != null) {
            end = end.next.next;
            mid = mid.next;
        }

        // Reverse the list from mid to end
        ListNode curr = mid;
        ListNode left = null;
        ListNode right;
        while (curr != null) {
            right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }

        // Compare the first half and the reversed second half
        ListNode check1 = head;
        ListNode check2 = left;
        while (check2 != null) {
            if (check1.val != check2.val) {
                return false;
            }
            check1 = check1.next;
            check2 = check2.next;
        }

        return true;
    }

    public static void main(String[] args) {
        LinkedlistPalindrome solution = new LinkedlistPalindrome();

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(1);

        boolean result1 = solution.isPalindrome(head1);
        System.out.println("Example 1: " + result1);  // Output: true

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        boolean result2 = solution.isPalindrome(head2);
        System.out.println("Example 2: " + result2);  // Output: false
    }
}
