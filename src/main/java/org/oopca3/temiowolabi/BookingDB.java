package org.oopca3.temiowolabi;

import java.util.ArrayList;

public class BookingDB
{
    private ArrayList<Booking> bookingList;

    public BookingDB() {
        this.bookingList = new ArrayList<>();
    }

    public void addBooking (String studentNumber, String computerID) //don't forget to add date of booking. Can use LocalDateTime thing for current date.
    {
        Booking newBooking = new Booking();
        bookingList.add( newBooking );
    }

    public void returnComputer (String studentNumber, String computerID)
    {
        
    }
}
