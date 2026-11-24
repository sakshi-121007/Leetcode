public class StringOccouence {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("sadbutsad", "sad"));
        System.out.println(new Solution().strStr("leetcode", "leeto"));
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
