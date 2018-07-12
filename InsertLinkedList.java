public class InsertLinkedList{
    
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
        
    }
    
    public static ListNode check(ListNode head){
    
        
        
        ListNode start = head;
       
        
        while(start!=null){
            if(start.val%2==0){
                
                ListNode ad = new ListNode(1);
                ad.next = start.next;
                start.next = ad;
                
            }
           
            start = start.next;
        
            
            
        }
        
        
        
        return head;    
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
