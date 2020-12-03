package org.oopca3.temiowolabi;

import java.time.LocalDate;

public class Booking
{
    private String bookingID;
    private String studentNumber;
    private String computerID;
    private LocalDate bookingTimeDate;
    private LocalDate returnTimeDate;
    private String assertTag;
    private String computerType;

    private static int nextBookingID = 0;// Next Booking ID
    // 'static' makes this a class variable, so all objects share this one
    // variable.  (i.e. each object does not have its own instance )

}
