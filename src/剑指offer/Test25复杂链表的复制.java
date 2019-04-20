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

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        //插入新结点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        //建立random连接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        //拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;
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
        StringBuffer sb=new StringBuffer();
        StringBuffer append = sb.append("aaa").append(1).append("true");

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
