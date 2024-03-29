package greedy.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReconstructQueue {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (i, j) -> {
            if (i[1] != j[1]) {
                return Integer.compare(i[1], j[1]);
            }
            return Integer.compare(-i[0], -j[0]);
        });

        List<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            int flag = p[1];
            if (res.size() == 0) {
                res.add(p);
                continue;
            }
            for (int i = 0; i <= res.size(); i++) {
                if (flag == 0) {
                    res.add(i, p);
                    break;
                }
                if (i == res.size()) {
                    res.add(p);
                }
                if (res.get(i)[0] >= p[0]) {
                    flag--;
                }
            }
        }
        return res.toArray(new int[res.size()][]);

    }

    /**
     * TODO 新思维：
     * 排序后，采用插入方法，排序后数组，第i个对前i-1个影响，对后i+1-n个影响？题干
     *
     * 题目：
     * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     * 请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
     * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
     * 输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
     * 解释：
     * 编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
     * 编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
     * 编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
     * 编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     * 编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
     * 编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
     * 因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
     *
     * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
     *
     * 题解：
     * 按照 h_i为第一关键字降序，k_i为第二关键字升序进行排序。如果我们按照排完序后的顺序，依次将每个人放入队列中，那么当我们放入第 i 个人时：
     * 1.第 0,⋯,i−1 个人已经在队列中被安排了位置，他们只要站在第 i 个人的前面，就会对第 i 个人产生影响，因为他们都比第 i 个人高；
     * 2.而第 i+1,⋯,n−1 个人还没有被放入队列中，并且他们无论站在哪里，对第 i 个人都没有任何影响，因为他们都比第 i 个人矮。
     * 后面的人既然不会对第 i 个人造成影响，可以采用「插空」的方法，依次给每一个人在当前的队列中选择一个插入的位置。
     * 也就是说，当我们放入第 i 个人时，只需要将其插入队列中，使得他的前面恰好有 k_i个人即可。
     */
    class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, new Comparator<int[]>() {
                public int compare(int[] person1, int[] person2) {
                    if (person1[0] != person2[0]) {
                        return person2[0] - person1[0];
                    } else {
                        return person1[1] - person2[1];
                    }
                }
            });
            List<int[]> ans = new ArrayList<int[]>();
            for (int[] person : people) {
                ans.add(person[1], person);
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
}
