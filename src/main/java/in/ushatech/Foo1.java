package in.ushatech;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo1 {
    private final Lock lock;

    private final Condition firstDone; 
    private final Condition secondDone;
    private boolean isFirstDone;
    private boolean isSecondDone;

    public Foo1() {
        lock = new ReentrantLock();
        firstDone = lock.newCondition();
        secondDone = lock.newCondition();

        isFirstDone = false;
        isSecondDone = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock(); // lock 
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            isFirstDone = true;
            firstDone.signal(); // Signal the condition that the first step is done
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (!isFirstDone) {
                firstDone.await(); // Wait until the first task is done
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            isSecondDone = true;
            secondDone.signal(); // Signal the condition that the second step is done
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (!isSecondDone) {
                secondDone.await(); // Wait until the second task is done
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
