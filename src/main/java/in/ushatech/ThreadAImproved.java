package in.ushatech;

public class ThreadAImproved {
    public static void main(String[] args) 
    {
        ThreadB b = new ThreadB(); // First we need an object on which to lock 

        b.start();

        synchronized (b)  // this is prerequisite for calling b.wait() as you need to aquire the lock on b object 
        {
            try {   
                while(b.isCompleted())
                {
                    System.out.println("Waiting for b to complete...");
                    b.wait();
                }               
            } catch (InterruptedException e) {
                System.out.println("Total is: " + b.total);
            }
        }
    }
}

class ThreadB extends Thread 
{
    int total;

    private boolean completed;

    public boolean isCompleted()
    {
        return completed;
    }

    public void run() {
        synchronized (this)  // here we have aquired lock on b object . This is why we can call notify() 
        // which means all threads waiting on b object will be notified
        {
            for (int i = 0; i < 100; i++) {
                total += i;
            }
            completed=true;
            notify(); // if this line runs before wait() then the thread will never notify and the other thread will remain waiting 
        }
    }
}


