package 剑指offer;


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

class Solution25 {

    public RandomListNode Clone(RandomListNode head) {
        if (head == null) {
            return null;
        }
        cloneNodes(head);//复制节点
        connectNodes(head);//链接random字段
        return reconnectNodes(head);//将整个链表拆分，返回复制链表的头结点
    }

    private void connectNodes(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    private void cloneNodes(RandomListNode head) {
        while (head != null) {
            RandomListNode tmp = new RandomListNode(-1);
            tmp.label = head.label;
            tmp.next = head.next;
            head.next = tmp;
            head = tmp.next;
        }
    }

    private RandomListNode reconnectNodes(RandomListNode head) {
        if (head == null)
            return null;
        
        RandomListNode newHead = head.next;
        RandomListNode pointer = newHead;
        head.next = newHead.next;
        head = head.next;
        while (head != null) {
            pointer.next = head.next;
            pointer = pointer.next;
            head.next = pointer.next;
            head = pointer.next;
        }
        return newHead;
    }
}

public class Test25复杂链表的复制 {
    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(-1);
        head.label = 1;
        head.next = new RandomListNode(-1);
        head.next.label = 2;
        head.next.next = new RandomListNode(-1);
        head.next.next.label = 3;
        head.next.next.next = new RandomListNode(-1);
        head.next.next.next.label = 4;
        head.next.next.next.next = new RandomListNode(-1);
        head.next.next.next.next.label = 5;
        head.random = head.next.next;
        head.next.random = head.next.next.next.next.next;
        head.next.next.next.random = head.next;
        RandomListNode tmp = head;
        printList(head);
        RandomListNode newHead = new Solution25().Clone(head);
        printList(newHead);
        System.out.println(isSame(head, tmp));

    }

    private static boolean isSame(RandomListNode h1, RandomListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1 == h2) {
                h1 = h1.next;
                h2 = h2.next;
            } else {
                return false;
            }
        }
        return h1 == null && h2 == null;
    }

    private static void printList(RandomListNode head) {
        while (head != null) {
            System.out.print(head.label + "->");
            head = head.next;
        }
        System.out.println("null");
    }
}
