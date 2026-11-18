
public class WaterTrap {

    public static void main(String[] args) {

        // Hardcoded input
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 0, 1, 2, 1 };

        // Create object of Solution class
        Solution obj = new Solution();

        // Call trap method
        int result = obj.trap(height);

        // Print output
        System.out.println("Trapped Rain Water: " + result);
    }
}

class Solution {

    public int trap(int[] height) {

        if (height == null || height.length <= 2) {
            return 0;
        }

        int total = 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                leftMax = Math.max(leftMax, height[left]);

                total += leftMax - height[left];

                left++;

            } else {

                rightMax = Math.max(rightMax, height[right]);

                total += rightMax - height[right];

                right--;
            }
        }

        return total;
    }
}
