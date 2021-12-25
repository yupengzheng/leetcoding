package greedy.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        int eraseCounter = 0;
        int i = 0;
        for (int j = 1; j < intervals.length; j++) {
            if (isOverlap(intervals[i], intervals[j])) {
                eraseCounter ++;
            } else {
                i = j;
            }
        }
        return eraseCounter;
    }

    /**
     * regionI[1] <= regionJ[1]始终
     * @param regionI
     * @param regionJ
     * @return
     */
    public boolean isOverlap(int[] regionI, int[] regionJ) {
        return regionI[1] > regionJ[0];
    }
}
