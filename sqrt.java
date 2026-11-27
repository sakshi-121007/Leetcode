public class sqrt {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] testInputs = { 0, 1, 4, 8, 16, 2147395599, 2147483647 };
        for (int x : testInputs) {
            System.out.println("mySqrt(" + x + ") = " + solution.mySqrt(x));
        }
    }

}

class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
