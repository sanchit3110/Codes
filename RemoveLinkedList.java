public class RemoveLinkedList{
    
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
        
    }
    
    public static ListNode check(ListNode head){
    
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = head;
        ListNode before = dummy;
        
        while(start!=null){
            if(start.val%2==0){
                before.next = start.next;
                start = before.next;
            }
            else{
                before = before.next;
                start = start.next;
            }
        }
        
        
        
        return dummy.next;    
    }
    
    
    
    
    
    
    public static void main(String []args){
        
        ListNode head = new ListNode(0);
        ListNode q = head;
        
        for(int i=1;i<8;i++){
            q.next = new ListNode(i);
            q = q.next;
        }
        
        ListNode ans = check(head.next);
        while(ans!=null){
            System.out.println(ans.val);
            ans = ans.next;
        }
     }
}
