package 剑指offer;

import java.util.ArrayList;

class Solution27 {
    private ArrayList<String> list = new ArrayList<>();

    /**
     * 题目:输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串 abc.
     * 则打印出由字符 a、b、c 所能排列出来的所有字符串 abc、acb、bac、cab和cba.
     *
     * @param str 等待排序的字符串
     * @return 所有全排列的集合
     */
    public ArrayList<String> Permutation(String str) {
        if (str != null && str.length() > 0) {
            char[] chars = str.toCharArray();
            permutation(chars, 0);
        }

        return list;
    }

    private void permutation(char[] chars, int begin) {
        if (chars.length - 1 == begin) {
            list.add(String.valueOf(chars));
        } else {
            for (int i = begin; i < chars.length; i++) {
                swap(chars, begin, i);
                permutation(chars, begin + 1);
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}

public class Test27字符串的排列 {
    public static void main(String[] args) {
        String str = "";
        ArrayList<String> permutation = new Solution27().Permutation(str);
        for (String s : permutation) {
            System.out.println(s);
        }
    }
}
