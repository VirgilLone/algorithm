package com.lw.algorithm.linear_list.singly_linked;

import org.junit.Test;


public class Solution {
    /**
     * 反转单链表：
     * 主要使用pre、current、nextNode三个节点从头移动到尾进行反转
     */
    public ListNode reverseLinked(ListNode head) {
        if(head == null)
            return null;
        // 当前head节点(1)作为pre
        ListNode pre =head;
        // head的next(2)作为current
        ListNode current =head.next;

        // 当前head节点作为反转后的尾节点，next应该为null       1  2 -> 3 -> 4 -> 5
//        pre.next=null;
        head.next=null;

        while (current!=null){
            ListNode nextNode = current.next;
            current.next=pre; // 1 <- 2 -> 3 -> 4 -> 5

            pre=current; // 将pre节点后移一位  pre=2
            current=nextNode; // 将current节点后移一位 current=3
        }
        return pre; // 返回反转后的头部节点
    }
    @Test
    public void reverseLinkedTest(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        ListNode result = reverseLinked(n1);
        System.out.println(result);

    }
    @Test
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next=n2;
        n2.next=n3;

        ListNode virtual=n1.next;
        n1.next=null;
        System.out.println(virtual.next);

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {val = x;}
    }
}
