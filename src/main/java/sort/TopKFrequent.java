package sort;

import java.util.*;

public class TopKFrequent {

    // TODO
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> counterMap = new HashMap<>();
        for (int i : nums) {
            counterMap.put(i, counterMap.getOrDefault(i, 0)+1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for (Map.Entry<Integer, Integer> m: counterMap.entrySet()) {
            int frequent = m.getValue();
            if (buckets[frequent] == null) {
                buckets[frequent] = new ArrayList<>();
            }
            buckets[frequent].add(m.getKey());
        }
        List<Integer> topK = new ArrayList<>(k);
        for (int i=buckets.length-1;topK.size()<k;i--) {
            if (buckets[i]==null) {
                continue;
            }
            if (topK.size()+buckets[i].size() <= k) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k-topK.size()));
            }
        }
        int[] res = new int[k];
        for (int i=0;i<k;i++) {
            res[i] = topK.get(i);
        }

        return res;
    }

}
