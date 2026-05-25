func hasDuplicate(nums []int) bool {
	hash := map[int]int{}
	for i := 0; i < len(nums); i++ {
		hash[nums[i]] += 1
		if hash[nums[i]] > 1 {
			return true
		}
	}
	return false
}