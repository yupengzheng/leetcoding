package greedy.algorithm;

public class MaxProfitII {
    /**
     * 思维：
     * 1.只能买入或卖出
     * 2.波峰波谷
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int totalProfit = 0;
        int buyIn = Integer.MAX_VALUE;
        for (int price : prices) {
            // 买入
            if (price < buyIn) {
                buyIn = price;
            }
            // 卖出
            else {
                totalProfit += (price - buyIn);
                buyIn = price;
            }
        }
        return totalProfit;
    }

    /**
     * 题目：给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     */
}
