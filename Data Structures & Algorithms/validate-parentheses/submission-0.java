class Solution {
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character, Character> map = new HashMap<>(3);
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');



        for (char elem: s.toCharArray()){
            if (elem == '[' || elem == '{' || elem == '('){
                stack.add(elem);
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }
                if (!stack.isEmpty()){
                    char temp = stack.removeLast();
//                    System.out.println(temp);
                    if (elem != map.get(temp)) {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;

    }

}