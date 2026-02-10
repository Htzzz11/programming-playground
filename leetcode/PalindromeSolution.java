public class PalindromeSolution {
    public boolean isPalindrome(String s) {
        String input = s.trim().toLowerCase();
        int i = 0;
        int j = input.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(input.charAt(i))) {
                i++;
                continue;
            } else if (!Character.isLetterOrDigit(input.charAt(j))) {
                j--;
                continue;
            }

            if (input.charAt(i) != input.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}
