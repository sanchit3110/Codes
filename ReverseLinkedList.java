
public class Main{
    
    
    public static class lnode {
        int val;
        lnode next;
        lnode(int x){
            val = x;
        }
    }
    
    
    
    
    public static lnode reverse(lnode head){
        
        
        lnode start = head;
        lnode prev = null;
        lnode after = start.next;
        
        while(start.next!=null){
            start.next = prev;
            prev = start;
            start = after;
            after = after.next;
        }
        
        start.next = prev;
        
        return start;
        
    }
    
    public static void printL(lnode ans){
        while(ans!=null){
            System.out.print(ans.val+"->");
            ans = ans.next;
        }
    }
    
    
    public static void main(String []args){
        
        
        lnode dummy = new lnode(0);
        lnode head = dummy;
        
        for(int i=1;i<3;i++){
            dummy.next = new lnode(i);
            dummy = dummy.next;
        }
        
        
        lnode ans = reverse(head.next);
        printL(ans);
        
        
     }
}
