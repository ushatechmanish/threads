package in.ushatech;

import java.util.HashSet;
import java.util.Set;

public final class  Show 
{
    private static volatile Show INSTANCE; // so that write to this is atomic , it is not cached 

    private Set<String> availableSeats;
    
    public static Show getInstance()
    {
        synchronized(Show.class)
        {
            if(INSTANCE == null)
            {
                INSTANCE= new Show();
            }
        }
        return INSTANCE;
    }

    private Show()
    {
        availableSeats= new HashSet<>();
        availableSeats.add("A1");
        availableSeats.add("A2");

    }
    public synchronized boolean  bookSeat(String seat)
    {
        return availableSeats.remove(seat);
    }


}
