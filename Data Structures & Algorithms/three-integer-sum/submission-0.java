class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); 

        for (int kIdx = 0; kIdx < nums.length - 2; kIdx++) {
            
            if (kIdx > 0 && nums[kIdx] == nums[kIdx - 1]) continue;

            int k = nums[kIdx];
            int i = kIdx + 1; 
            int j = nums.length - 1;

            while (i < j) {
                int sum = nums[i] + nums[j];

                if (sum > -k) {
                    j--;
                } else if (sum < -k) {
                    i++;
                } else {
                    result.add(Arrays.asList(k, nums[i], nums[j]));
                    
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j] == nums[j - 1]) j--;

                    i++;
                    j--;
                }
            }
        }
        return result;
    }}