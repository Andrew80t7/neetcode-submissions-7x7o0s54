class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];

        int left = 0;
        int maxCount = 0;

        int maxLength = 0;

        for (int right = 0; right < s.length(); ++right) {

            counts[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, counts[s.charAt(right) - 'A']);

            int windowLength = right - left + 1;
            if (windowLength - maxCount > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

//        System.out.println(counts);
        return maxLength;
    }
}