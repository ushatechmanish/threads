package in.ushatech;

/**
 * MultiThreading practice
 */
public final class App {
    private App() {
    }

    public static void main(String[] args) {

        System.out.println("Run by : "+Thread.currentThread().getName());

        Thread t = new Thread(()-> {
            System.out.println("Run by : "+Thread.currentThread().getName()); // running
            // when run method completes . This is dead .
        },"Thread1"); // state new 


        t.start(); // Runnable 

        try {
            Thread.sleep(50); // sleeping  // t.sleep() does not work as it is a static method  
            // yield and sleep are also static method . These are for current thread only . So main 
            // thread will sleep;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            t.join(); // main thread is waiting on new thread created  // non static method
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

        // thread can be blocked based on the IO operationresult waiting 

        t.run();// even after execution the run method or other methods can be called but not start();

        // t.start(); // illegal state exception 
        // Thread scheduler is the orchestrator 

    }


}
