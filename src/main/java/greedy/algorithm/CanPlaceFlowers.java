package greedy.algorithm;

public class CanPlaceFlowers {

    // TODO 转化为迭代：两个挡板之间的零数
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int pre = -2;
        int counter = 0;
        for (int i=0;i<=flowerbed.length;i++) {
            if (i == flowerbed.length || flowerbed[i] == 1) {
                if (i == flowerbed.length) {
                    i++;
                }
                counter += (i-pre-2)/2;
                pre = i;
            }
        }
        return counter >= n;
    }
}
