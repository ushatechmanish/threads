package in.ushatech;

    // Important wait() , notify() and notifyAll() should be called from a synchronized context 

    // because the thread can not invoke a wait or notify on an object unless it owns that object's lock


public class ThreadA {
    public static void main(String[] args) 
    {
        ThreadB b = new ThreadB(); // First we need an object on which to lock 

        b.start();

        synchronized (b)  // this is prerequisite for calling b.wait() as you need to aquire the lock on b object 
        {
            try {
                System.out.println("Waiting for b to complete...");
                b.wait();
            } catch (InterruptedException e) {
                System.out.println("Total is: " + b.total);
            }
        }
    }
}

class ThreadB extends Thread 
{
    int total;

    public void run() {
        synchronized (this)  // here we have aquired lock on b object . This is why we can call notify() 
        // which means all threads waiting on b object will be notified
        {
            for (int i = 0; i < 100; i++) {
                total += i;
            }
            notify(); // if this line runs before wait() then the thread will never notify and the other thread will remain waiting 
        }
    }
}
