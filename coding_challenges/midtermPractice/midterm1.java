import java.lang.String;

class Solution {
    public boolean isPalindrome(String s) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        s = s.toLowerCase(s);

        String sch = s.toCharArray();
        System.out.println(sch);

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < alpha.length(); j++) {
                if (s.charAt(i) != alpha.charAt(j)) {
                    s.replace(s.charAt(i), "");
                }
            }
        }
        System.out.println(s);
        char left , right;
        for (int i = 0; i < s.length(); i++) {
            left = s.charAt(i);
            right = s.charAt(s.length() - (i + 1));
            if (left == right) {
                // true but continue
            }
            System.out.print(right);
        }
    }
}