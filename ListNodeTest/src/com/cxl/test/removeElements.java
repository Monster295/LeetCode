package com.cxl.test;


public class removeElements {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(0);
        ListNode n6 = new ListNode(6);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode res = removeElements(head, 0);
        while (res != null) {
            System.out.print(res.val + "\t");
            res = res.next;
        }

    }


    public static ListNode removeElements(ListNode head, int val) {
        //创建虚拟节点
        ListNode vNode = new ListNode(-1, head);
        ListNode pre = vNode;
        ListNode cur = head;
        if (head == null) {
            return head;
        }
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;  //pre也需要后移
            }
            cur = cur.next;
        }
        return vNode.next;
    }

    //不适用虚拟节点
    public static ListNode removeElements_1(ListNode head,int val){
        //要处理头节点需要删除的情况
        while(head != null && head.val == val){
            head = head.next;
        }
        if(head == null){
            return head;
        }
        //定义pre、cur节点
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //不适用虚拟节点，pre节点
    public static ListNode removeElements_2(ListNode head,int val){
        //处理头节点需要删除的情况
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
