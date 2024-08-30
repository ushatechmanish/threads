package in.ushatech;

public class RaceCondition {
    
    // Race condition happens when 2 threads are trying to change a shared resource at the same time and 
    // result is dependent on the order in which code is executed by threads 

    // public static SingletonInstance getInstant()
    // {
    //     if(INSTANCE== null)
    //     {
    //         INSTANCE=new Singleton();
    //     }
    //     return INSTANCE;
    // }

    // Solution 1

    // public static  synchronized SingletonInstance getInstant()
    // {
    //     if(INSTANCE== null)
    //     {
    //         INSTANCE=new Singleton();
    //     }
    //     return INSTANCE;
    // }

    // solution 2 

    // public static  synchronized SingletonInstance getInstant()
    // {
    //     if(INSTANCE== null)
    //     {
    //         INSTANCE=new Singleton();
    //     }
    //     return INSTANCE;
    // }
}
