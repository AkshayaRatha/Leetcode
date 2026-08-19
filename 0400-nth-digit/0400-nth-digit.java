class Solution {
    public int findNthDigit(int n) {
        if(n<10) return n;
        long sum = 9, numberOfDigits = 2, pow=10;
        while(true) {
            long countDigits = ((pow*10) - pow)*numberOfDigits;
            if(sum+countDigits>=n) {
                long diff = ((n-sum-1)/numberOfDigits)+1;
                long digit = (n-sum)%numberOfDigits;
                long num = pow -1+diff;
                if(digit==0) return (int)(num%10);
                return Long.toString(num).charAt((int)digit-1)-'0';
            }
            sum+=countDigits;
            numberOfDigits++;
            pow*=10;
        }
    }
}