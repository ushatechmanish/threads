package in.ushatech;
// https://leetcode.com/problems/print-in-order/
class Foo 
{
    boolean first;
    boolean second;
    public Foo() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first=true;
        notifyAll();

    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(!first)
        {
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second=true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(!second)
        {
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    
    }
}