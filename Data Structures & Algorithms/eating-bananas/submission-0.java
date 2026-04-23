class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int hight = java.util.Arrays.stream(piles).max().getAsInt();
        int result = hight;
        while (low <= hight) {
            int mid = low + (hight - low) / 2;

            long timeMid = 0;

            for (int pile : piles) {
                timeMid += (pile + mid - 1) / mid;
            }

            if (timeMid <= h) {
                result = mid;
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}