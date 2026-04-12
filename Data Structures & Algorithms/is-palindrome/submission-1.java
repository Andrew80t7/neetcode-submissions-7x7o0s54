
class Solution {
    public boolean isPalindrome(String s) {
        boolean flag = true;


        String normS = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//        System.out.println(normS);

        int i = 0;
        int j = normS.length() - 1;

        while (i < j){
            if (normS.charAt(i) != normS.charAt(j)){
                flag = false;
                break;
            }
            i++;
            j--;
        }
        return flag;
    }

}
