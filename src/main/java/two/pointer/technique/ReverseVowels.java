package two.pointer.technique;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//TODO LeetCode 345 左右指针分阶段进行
public class ReverseVowels {

    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int left = 0;
        int right = s.length() - 1;
        char[] res = new char[s.length()];
        while (left <= right) {
            char cl = s.charAt(left);
            char cr = s.charAt(right);
            if (!vowels.contains(Character.toLowerCase(cl))) {
                res[left++] = cl;
            } else if (!vowels.contains(Character.toLowerCase(cr))) {
                res[right--] = cr;
            } else {
                res[left++] = cr;
                res[right--] = cl;
            }
        }
        return new String(res);
    }
}
