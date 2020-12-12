package org.oopca3.temiowolabi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking extends Student {
    private String bookingID;
    private String bookingTimeDate;
    private String returnTimeDate;
    private String computerType;
    private String assertTag;
    private String studentNumber;
   // private String computerID;

    private static int nextBookingID = 0;// Next Booking ID
    // 'static' makes this a class variable, so all objects share this one
    // variable.  (i.e. each object does not have its own instance )

    public Booking()
    {
        super();

    }

    public Booking(String bookingID, String bookingTimeDate, String returnTimeDate, String computerType, String assertTag, String studentNumber) {
        this.bookingID = bookingID;
        this.bookingTimeDate = bookingTimeDate;
        this.returnTimeDate = returnTimeDate;
        this.computerType = computerType;
        this.assertTag = assertTag;
        this.studentNumber = studentNumber;
    }

    public String getBookingID() {
        return bookingID;
    }

    public String getBookingTimeDate() {
        return bookingTimeDate;
    }

    public String getReturnTimeDate() {
        return returnTimeDate;
    }

    public String getComputerType() {
        return computerType;
    }

    public String getAssertTag() {
        return assertTag;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    @Override
    public String toString() {
        return '\n' + "Booking Information: " +
                "Booking ID = " + bookingID +
                " Booking Date & Time = " + bookingTimeDate +
                " Return Date & Time = " + returnTimeDate +
                " Computer Type= " + computerType +
                " Assert Tag = " + assertTag +
                ", studentNumber= " + studentNumber + '\n';
    }


}
