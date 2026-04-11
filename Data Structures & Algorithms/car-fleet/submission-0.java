class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> timeStack = new ArrayDeque<Double>();

        int ln = position.length;

        int[][] table = new int[ln][2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < ln; ++i) {
            map.put(position[i], speed[i]);
        }

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(map);
//        System.out.println(sortedMap);

        for (int i: sortedMap.descendingKeySet()){

            double currTime = ((double)(target - i)/sortedMap.get(i));

            if (timeStack.isEmpty() || currTime > timeStack.peek()){
                timeStack.push(currTime);
            }
        }
//        System.out.println(timeStack);

        return timeStack.size();
    }
}