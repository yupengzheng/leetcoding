package greedy.algorithm;

public class CheckPossibility {

    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int cnt = 0;
        for (int i=1; i<nums.length && cnt < 2;i++) {
            if (nums[i]>=nums[i-1]) {
                continue;
            }
            cnt ++;
            if (i>=2 && nums[i-2] > nums[i]) {
                nums[i] = nums[i-1];
            } else {
                nums[i-1] = nums[i];
            }
        }
        return cnt < 2;
    }
}
