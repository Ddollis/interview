package 剑指offer;


import java.util.ArrayList;
import java.util.Arrays;

class Solution38{
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) {
            return ret;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuilder());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUserd, StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUserd[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasUserd[i - 1])
                continue;
            hasUserd[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUserd, s);
            s.deleteCharAt(s.length() - 1);
            hasUserd[i] = false;
        }
    }
}

public class Test38字符串的排列 {
    public static void main(String[] args) {
        ArrayList<String> list = new Solution38().Permutation("abc");
        System.out.println(list);
    }
}
