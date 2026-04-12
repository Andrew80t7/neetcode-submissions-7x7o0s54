class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 1;
        int j = numbers.length;

        Arrays.sort(numbers);
        int[] result = new int[2];


        while (i < j) {

            int left = numbers[i - 1];
            int right = numbers[j - 1];

            if (left + right < target) {
                i++;
            }
            if (left + right > target){
                j--;
            }
            if (left + right == target){
                result[0] = i;
                result[1] = j;
                break;
            }
        }
        return result;

    }
}