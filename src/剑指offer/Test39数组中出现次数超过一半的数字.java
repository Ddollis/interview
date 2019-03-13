package 剑指offer;

class Solution39 {
    public int MoreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for (int i = 1, cnt = 1; i < nums.length; i++) {
            cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
            if (cnt == 0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        int cnt = 0;
        for (int val : nums)
            if (val == majority)
                cnt++;
        return cnt > nums.length / 2 ? majority : 0;
    }
}

public class Test39数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 2, 2, 3, 3, 4, 4, 4, 5, 2, 2, 2};
        System.out.println(new Solution39().MoreThanHalfNum_Solution(nums));
    }
}
