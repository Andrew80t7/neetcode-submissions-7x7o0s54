class Solution{
    public int evalRPN(String[] tokens){
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token: tokens){
            try {
                stack.add(Integer.parseInt(token));
            } catch (NumberFormatException e){
                int elem1 = stack.removeLast();
                int elem2 = stack.removeLast();
                switch (token){
                    case "+":
                        stack.add(elem1 + elem2);
                        break;
                    case "-":
                        stack.add(elem2 - elem1);
                        break;
                    case "*":
                        stack.add(elem1 * elem2);
                        break;
                    case "/":
                        stack.add(elem2 / elem1);
                        break;
                }
            }
        }
        return stack.removeLast();
    }
}