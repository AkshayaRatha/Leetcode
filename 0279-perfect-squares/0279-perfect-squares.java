class Solution {
    //Using Lagrange’s Four-Square Theorem
    public boolean isSquare(int n) {
        int x = (int) Math.sqrt(n);
        return x * x == n;
    }
    public int numSquares(int n) {
        if (isSquare(n)) return 1;
        for (int i = 1; i * i <= n; i++) {
            if (isSquare( n - i * i)) return 2;
        }
        int m = n;
        while ((m & 3) == 0) m = m >> 2;
        if ((m & 7) == 7) return 4;
        return 3;
    }
}