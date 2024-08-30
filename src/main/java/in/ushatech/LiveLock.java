package in.ushatech;

public class LiveLock {
    // There are 2 locks to be aquired for a work 
    // Thread 1 aquires lock1 and Thread2 aquired lock2 
    // Now Thread1 see the lock2 is not available so it releases the lock 1 so that Thread2 can complete 
    // Then it tries to get the locks 1 and 2 again after some time 
    // Simultaneously Thread2 see the lock1 is not available so it releases the lock 2 so that Thread2 can complete 
    // Then it tries to get the lock 2 and lock 1 again after some time

    // if both the operation happens simultaneously , we have  a livelock 

    // The solution is to use Reentrant locks 
    
}
