package org.oopca3.temiowolabi;

import java.util.Comparator;

public class datesInAscendingOrder implements Comparator<Booking>
{
    @Override
    public int compare(Booking dateOne, Booking dateTwo)
    {
        if(dateOne.getBookingTimeDate().isBefore(dateTwo.getBookingTimeDate()))
        {
            return -1;
        }
        if(dateOne.getBookingTimeDate().isBefore(dateTwo.getBookingTimeDate()))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
