package sort;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencySort {

    public String frequencySort(String s) {
        Map<Character, Integer> counterMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            counterMap.put(c, counterMap.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new List[s.length()+1];
        for (Map.Entry<Character, Integer> pairs : counterMap.entrySet()) {
            int rankNum = pairs.getValue();
            if (buckets[rankNum] == null) {
                buckets[rankNum] = new ArrayList<>();
            }
            buckets[rankNum].add(pairs.getKey());
        }
        StringBuilder res = new StringBuilder();
        for (int j=buckets.length-1;j>0;j--) {
            if (buckets[j] == null) {
                continue;
            }
            for (char c : buckets[j]) {
                for (int i=0;i<j;i++) {
                    res.append(c);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(new FrequencySort().frequencySort(s));
    }
}
