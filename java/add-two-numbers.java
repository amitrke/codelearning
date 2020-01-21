/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean hasMoreToAdd = true;
        int carry=0;
        ListNode result = null;
        ListNode currentNode = null;
        
        while(hasMoreToAdd){
            int l1d = l1 != null ? l1.val : 0;
            int l2d = l2 != null ? l2.val : 0;
            
            //Add current column digits
            System.out.println("Adding l1d="+l1d+", l2d="+l2d+",carry="+carry);
            int sum = l1d + l2d + carry;
            if (sum/10 < 1){
                carry = 0;
            } else {
                carry = sum / 10;
                sum = sum % 10;
                System.out.println("Sum="+sum+", carry="+carry);
            }
            
            if (result == null){
                result = new ListNode(sum);
                currentNode = result;
            } else {
                currentNode.next = new ListNode(sum);
                currentNode = currentNode.next;
            }
            
            if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || carry != 0){
                if (l1 != null && l1.next != null){
                    l1 = l1.next;
                } else {
                    l1 = null;
                }
                
                if (l2 != null && l2.next != null){
                    l2 = l2.next;
                } else {
                    l2 = null;
                }
            } else {
                hasMoreToAdd = false;
            }
        }
        return result;
    }
}