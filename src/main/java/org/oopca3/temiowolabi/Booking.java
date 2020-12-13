package org.oopca3.temiowolabi;

import java.time.LocalDateTime;

public class Booking extends Student {
    private String bookingID;
    private LocalDateTime bookingTimeDate;
    private LocalDateTime returnTimeDate;
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

    public Booking(String bookingID, String borrowComp, String returnComp, String computerType, String assertTag, String studentNumber) {
        super();
        this.bookingID = bookingID;
//        this.bookingTimeDate = bookingTimeDate;
//        this.returnTimeDate = returnTimeDate;
        this.bookingTimeDate = LocalDateTime.parse(borrowComp);
        if(!returnComp.isEmpty())
        {
            this.returnTimeDate = LocalDateTime.parse(returnComp);
        }
        this.computerType = computerType;
        this.assertTag = assertTag;
        this.studentNumber = studentNumber;
    }

    public String getBookingID() {
        return bookingID;
    }

    public LocalDateTime getBookingTimeDate() {
        return bookingTimeDate;
    }

    public LocalDateTime getReturnTimeDate() {
        return returnTimeDate;
    }

    public void setReturnTimeDate(LocalDateTime returnTimeDate) {
        this.returnTimeDate = returnTimeDate;
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
