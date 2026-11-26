public class pow {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println("2.0^10 = " + solution.myPow(2.0, 10));
        System.out.println("2.1^3 = " + solution.myPow(2.1, 3));
        System.out.println("2.0^-2 = " + solution.myPow(2.0, -2));
        System.out.println("2.0^-2147483648 = " + solution.myPow(2.0, Integer.MIN_VALUE));
    }
}

class Solution {
    public double myPow(double x, int n) {
        long exp = Math.abs((long) n);

        double result = 1.0;
        double currentProduct = x;

        while (exp > 0) {
            if ((exp & 1L) == 1L) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            exp >>= 1;
        }

        return n < 0 ? 1.0 / result : result;
    }
}