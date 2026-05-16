class Solution {

    public static boolean isPermutation(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int windowLength = s1.length();

        if (windowLength > s2.length()) return false;

        for (int i = 0; i <= s2.length() - windowLength; i++) {
            String currentWindow = s2.substring(i, i + windowLength);

            if (isPermutation(s1, currentWindow)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(checkInclusion("abc", "lecabee"));
    }
}
