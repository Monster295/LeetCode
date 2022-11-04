/*
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * */

public class Que_203 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,null);
        head.next=new ListNode(2,null);
        head.next.next=new ListNode(6,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,null)))));
//        ListNode cur = head;
//        while(cur!=null){
//            System.out.print(cur.val+" ");
//            cur=cur.next;
//        }
        ListNode res = removeElements_2(head, 6);
        while(res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        //创建虚拟节点，解决head节点的需要删除的情况
        ListNode vNode = new ListNode(-1,head);//vNode是head的前一个结点
        ListNode pre = vNode;   //当前操作节点的前一个节点
        ListNode cur = head;   //当前正在操作的节点
        while(cur != null){ //如果当前节点不空
            if(cur.val == val) {  //当前节点是需要删除的节点
                pre.next = cur.next;    //pre节点的next指向cur节点的next，即删除了当前操作的节点
            }else{  //当前节点不需要删除
                pre = cur;  //将cur节点赋值给pre节点，方便节点后移
            }
            cur=cur.next;   //将当前操作的节点后移
        }
        return vNode.next;  //vNode是新head的前一个节点，此时遍历完成，将head节点，也就是vNode.next返回
    }

    public static ListNode removeElements_1(ListNode head,int val){
        //不使用虚拟节点
        while(head!=null && head.val == val){
            head = head.next;
        }
        //已经是null,提前退出
        if(head == null){
            return head;
        }
        //已经确定当前head.val!=val
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //不添加虚拟节点，不使用pre Node
    public static ListNode removeElements_2(ListNode head,int val){
        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode cur = head;
        while(cur != null){
            while(cur.next != null && cur.next.val == val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

}
