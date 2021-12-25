package greedy.algorithm;

import java.util.Arrays;
import java.util.Comparator;

// TODO 聚焦最右位置
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, Comparator.comparingInt(i -> i[1]));
        int noOverlapCounter = 1;
        int[] coverRegion = points[0];
        for (int j=1;j<points.length;j++) {
            if (isOverlap(coverRegion, points[j])) {
                // 该行没用
                coverRegion[0] = Math.max(coverRegion[0], points[j][0]);
            } else {
                coverRegion = points[j];
                noOverlapCounter ++;
            }
        }
        return noOverlapCounter;
    }

    /**
     * regionI[1] <= regionJ[1] 始终
     * @param regionI
     * @param regionJ
     * @return
     */
    private boolean isOverlap(int[] regionI, int[] regionJ) {
        return regionI[1] >= regionJ[0];
    }

    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
