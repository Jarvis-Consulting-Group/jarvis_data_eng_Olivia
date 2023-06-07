import java.lang.String;
import java.lang.StringBuilder;

class MidtermSolution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        System.out.println("String to Check Palindrome: ", sb); // debug
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        MidtermSolution solution = new MidtermSolution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // Output: true
        //System.out.println(solution.isPalindrome("race a car")); // Output: false
        //System.out.println(solution.isPalindrome(" ")); // Output: true
    }
}