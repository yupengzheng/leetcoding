package greedy.algorithm;

import java.util.Arrays;
import java.util.Collections;

public class AssignCookies {

    public int findContentChildren(int[] childAppetiteCapacityList, int[] cookieSizeList) {
        int counter = 0;
        if (childAppetiteCapacityList == null || cookieSizeList == null) {
            return counter;
        }
        Arrays.sort(childAppetiteCapacityList);
        Arrays.sort(cookieSizeList);
        int childIndex = 0;
        int cookieIndex = 0;
        while (childIndex<childAppetiteCapacityList.length && cookieIndex<cookieSizeList.length) {
            if (childAppetiteCapacityList[childIndex] <= cookieSizeList[cookieIndex]) {
                counter ++;
                childIndex ++;
            }
            cookieIndex ++;
        }
        return counter;
    }

}
