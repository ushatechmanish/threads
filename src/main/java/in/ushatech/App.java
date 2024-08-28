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
            System.out.println("Run by : "+Thread.currentThread().getName());
        },"Thread1");
        t.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        t.run();

        t.start(); // illegal
    }


}
