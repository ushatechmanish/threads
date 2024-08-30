package in.ushatech;

public class DeadLock {
    private static class Resource {
        public int value;
    }

    private Resource a = new Resource();
    private Resource b = new Resource();

    // if the following 2 methods read() and commented write methods are accessed by 2 threads 
    public int read() {
        synchronized (a) {  // step 1 a is aquired by thread1 and now it wants to aquire b // step3  but b is already aquired by threa2, so it waits for thread2 to complete  and hence deadlock 
            synchronized (b) {
                return a.value + b.value;
            }
        }

    }

    // public void write(int val1, int val2) {
    //     synchronized (b) { // meanwhile b is aquired by thread2 and now it wants to aquire a  but a is already aquired by threa1 , so it waits for thread1 to complete 
    //         synchronized (a) {
    //             a.value = val1;
    //             b.value = val2;
    //         }
    //     }
    // }


    public void write(int val1, int val2) {
        synchronized (a) {
            synchronized (b) {
                a.value = val1;
                b.value = val2;
            }
        }
    }

    // to prevent deadlock the order of aquiring locks should be same 
}
