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
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     ListNode list1=reverse(l1);
     ListNode list2=reverse(l2);
     int sum=0;
     ListNode head=new ListNode();
     ListNode temp=head;
    int carry=0;
     while(list1!=null || list2!=null|| carry!=0){
        sum=carry;
        if(list1!=null){
            sum+=list1.val;
            list1=list1.next;
        }
        if(list2!=null){
            sum+=list2.val;
            list2=list2.next;
        }
        carry=sum/10;
        temp.next=new ListNode(sum%10);
        temp=temp.next;
     }return reverse(head.next);
    }
}