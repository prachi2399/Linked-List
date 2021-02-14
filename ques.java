public class ques{
    void reorder(ListNode head){
        ListNode h1=head;
        ListNode h2=head.next;
        ListNode c1=h1;
        ListNode c2=h2;
        while(c2!=null||c2.next!=null){
            ListNode f=c2.next;
             c1.next=f;
             c2.next=f.next;
             c1=c1.next;
             c2=c2.next;
        }
        c1.next=null;
        h2=reverseList(h2);
        c1.next=h2;
    }
}