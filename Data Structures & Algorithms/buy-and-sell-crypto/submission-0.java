class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int volume = price - minPrice;

            if (volume > maxProfit) {
                maxProfit = volume;
            }
        }

        return maxProfit;
    }
}