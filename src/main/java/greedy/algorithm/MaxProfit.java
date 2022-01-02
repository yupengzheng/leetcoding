package greedy.algorithm;

public class MaxProfit {
    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }
        int profit = 0;
        // int buyIn = prices[0];
        int buyIn = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < buyIn) {
                buyIn = price;
            } else {
                profit = Math.max(profit, price-buyIn);
            }
        }
        return profit;
    }
}
