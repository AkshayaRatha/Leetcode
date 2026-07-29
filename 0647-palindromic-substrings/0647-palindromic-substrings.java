class Solution {
    public int countSubstrings(String s) {
        int left = 0;
        int right = 0;
        int count = 0;

        while (left < s.length()) {
            for (right = left; right < s.length(); right++) {
                if (isPalindrome(s.substring(left, right + 1))) {
                    count++;
                }
            }
            left++;
        }

        return count;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}