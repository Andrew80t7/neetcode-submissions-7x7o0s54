class Solution {
    static int longestConsecutive(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);

        UnionFind unions = new UnionFind(nums.length);

        for (int i = 0; i < nums.length; ++i) {
            hashMap.put(nums[i], i);
        }
        for (int num : hashMap.keySet()) {
            if (hashMap.containsKey(num + 1)) {
                unions.union(hashMap.get(num), hashMap.get(num + 1));
            }
        }

        return unions.getMaxSize();
    }
}

static class UnionFind {
    private int[] parent;
    private int[] size;

    public UnionFind(int n) {

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            if (size[rootI] < size[rootJ]) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            } else {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            }
        }
    }

    public int getMaxSize() {
        int res = 0;
        for (int s : size) {
            if (s > res) {
                res = s;
            }
        }
        return res;
    }
}