class ZeroEvenOdd {
    private int n;
    private boolean zeroPrinted;
    private int currentNumber;
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zeroPrinted = false;
        this.currentNumber = 1;
    }
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(currentNumber <= n)
        synchronized(this) {
            while(zeroPrinted == true)
                wait();
            if(currentNumber <= n) {
                printNumber.accept(0); 
            }  
            zeroPrinted = true;
            notifyAll();
        
        }
    }
    public void even(IntConsumer printNumber) throws InterruptedException {
            while(currentNumber <= n)
            synchronized(this) {
                while(currentNumber % 2 == 1 || zeroPrinted == false) 
                    wait();
                if(currentNumber <= n) {
                    printNumber.accept(currentNumber); 
                }      
                zeroPrinted = false;
                currentNumber++;
                notifyAll();
            }
        }
    public void odd(IntConsumer printNumber) throws InterruptedException {
            while(currentNumber <= n)
            synchronized(this) {
                while(currentNumber % 2 == 0 || zeroPrinted == false) 
                wait();
            if(currentNumber <= n) {
                printNumber.accept(currentNumber); 
            }    
            zeroPrinted = false;
            currentNumber++;  
            notifyAll();
            }
        } 
}