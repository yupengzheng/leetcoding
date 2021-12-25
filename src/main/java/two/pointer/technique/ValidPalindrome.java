package two.pointer.technique;

public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        if (s.isEmpty()) return true;
        String temp = tripPalindrome(s);
        return temp.isEmpty() || tripPalindrome(temp.substring(1)).isEmpty() || tripPalindrome(temp.substring(0, temp.length() - 1)).isEmpty();
    }

    public String tripPalindrome(String temp) {
        int left = 0;
        int right = temp.length() - 1;
        while (left < right) {
            if (temp.charAt(left) == temp.charAt(right)) {
                left++;
                right--;
            } else {
                return temp.substring(left, right + 1);
            }
        }
        return "";
    }
}