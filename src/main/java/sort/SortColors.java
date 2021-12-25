package sort;

public class SortColors {

    // TODO 作图分析逻辑 各种情况的case
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i=0; i<nums.length;i++) {
            if (nums[i] == 0) {
                swap(nums, i, p0++);
                if (nums[i] == 1) {
                    swap(nums, i, p1++);
                } else {
                    p1 ++;
                }
            } else if (nums[i] == 1) {
                swap(nums, i, p1++);
            }
        }
    }

    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public void sortColors2(int[] nums) {
        int p0 = -1;
        int p2 = nums.length;
        int i = 0;
        while (i<p2) {
            if (nums[i] == 0) {
                swap(nums, ++p0, i++);
            } else if (nums[i] == 2) {
                swap(nums, --p2, i);
            } else {
                i++;
            }
        }
    }
}
