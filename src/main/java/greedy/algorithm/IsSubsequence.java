package greedy.algorithm;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0 || t.length() < s.length()) {
            return false;
        }

        int ps = 0;
        for (int i=0; i<t.length();i++) {
            if (ps >= s.length()) {
                return true;
            }
            char temp = s.charAt(ps);
            if (temp == t.charAt(i)) {
                ps ++;
            }
        }

        return ps == s.length();

    }

    /*
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
     */
}
