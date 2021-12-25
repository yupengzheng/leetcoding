package two.pointer.technique;

public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {
        int right = (int)Math.sqrt(c);
        int left = 0;
        while (left <= right) {
            int sum = left * left + right * right;
            if (sum < c) {
                left ++;
            } else if (sum > c) {
                right --;
            } else {
                return true;
            }
        }
        return false;
    }
}
