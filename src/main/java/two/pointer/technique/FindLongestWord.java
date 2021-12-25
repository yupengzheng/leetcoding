package two.pointer.technique;

import java.util.List;

// TODO 初始条件与符合条件的case 怎么处理 -> 增加判断条件
public class FindLongestWord {

//    public String findLongestWord(String s, List<String> dictionary) {
//        String res = "";
//        for (String word: dictionary) {
//            // 初始条件与满足条件不符
//            if (isSubsequence(word, s) && word.length() >= res.length() && word.compareTo(res) < 0) {
//                res = word;
//            }
//        }
//        return res;
//    }

    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String word: dictionary) {
            if (word.length() < res.length() || (word.length()==res.length() && res.compareTo(word) < 0)) {
                continue;
            }
            if (isSubsequence(word, s)) {
                res = word;
            }
        }
        return res;
    }

    public boolean isSubsequence(String word, String s) {
        int pWord = 0;
        int pS = 0;
        while (pS < s.length() && pWord < word.length()) {
            if (s.charAt(pS) == word.charAt(pWord)) {
                pWord ++;
            }
            pS ++;
        }
        return pWord == word.length();
    }
}
