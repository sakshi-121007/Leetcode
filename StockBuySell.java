public class StockBuySell {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        System.out.println("Maximum profit: " + solution.maxProfit(prices));
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}