package 剑指offer;

import javafx.scene.transform.Rotate;

/**
 * 二叉树根节点
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution26 {
    /**
     * 题目：输入一颗二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的节点，只能调整树中结点指针的指向。
     *
     * @param pRootOfTree 二叉树的根结点
     * @return 双向链表的头结点
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        //用于保存处理过程中的双向链表的尾结点
        //因为数组可以通过地址传递
        TreeNode[] lastNode = new TreeNode[1];
        convertNode(pRootOfTree, lastNode);
        //找到双向链表的头结点
        TreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private void convertNode(TreeNode node, TreeNode[] lastNode) {
        if (node != null) {
            if (node.left != null) {
                convertNode(node.left, lastNode);
            }
            node.left = lastNode[0];
            if (lastNode[0] != null) {
                lastNode[0].right = node;
            }
            lastNode[0] = node;
            if (node.right != null) {
                convertNode(node.right, lastNode);
            }
        }
    }
}

public class Test26二叉搜索树与双向链表 {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
        test05();
    }

    private static void printList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.right;
        }
        System.out.println("null");
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + "->");
            printTree(root.right);
        }
    }

    private static void test05() {
        System.out.println("Before convert:");
        printTree(null);
        System.out.println("null");
        TreeNode head = new Solution26().Convert(null);
        System.out.println("After convert:");
        printList(head);
        System.out.println();
    }

    private static void test04() {
        TreeNode node1 = new TreeNode(1);
        System.out.println("Before convert:");
        printTree(node1);
        System.out.println("null");
        TreeNode head = new Solution26().Convert(node1);
        System.out.println("After convert:");
        printList(head);
        System.out.println();
    }


    private static void test03() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        System.out.println("Before convert:");
        printTree(node1);
        System.out.println("null");
        TreeNode head = new Solution26().Convert(node1);
        System.out.println("After convert:");
        printList(head);
        System.out.println();
    }

    private static void test02() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        System.out.println("Before convert:");
        printTree(node1);
        System.out.println("null");
        TreeNode head = new Solution26().Convert(node1);
        System.out.println("After convert:");
        printList(head);
        System.out.println();
    }

    private static void test01() {
        TreeNode node10 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node14 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node12 = new TreeNode(12);
        TreeNode node16 = new TreeNode(16);

        node10.left = node6;
        node10.right = node14;
        node6.left = node4;
        node6.right = node8;
        node14.left = node12;
        node14.right = node16;
        System.out.println("Before convert:");
        printTree(node10);
        System.out.println("null");
        TreeNode head = new Solution26().Convert(node10);
        System.out.println("After convert:");
        printList(head);
        System.out.println();
    }
}
