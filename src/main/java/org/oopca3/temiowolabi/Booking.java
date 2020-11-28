package org.oopca3.temiowolabi;

public class Booking
{
    private String BookingID;
    private String BookingDate_Time;
    private String ReturnDate_Time;
    private String ComputerType;
    private String ComputerAssetTag;


    public Booking(String bookingID, String bookingDate_Time, String returnDate_Time, String computerType, String computerAssetTag) {
        BookingID = bookingID;
        BookingDate_Time = bookingDate_Time;
        ReturnDate_Time = returnDate_Time;
        ComputerType = computerType;
        ComputerAssetTag = computerAssetTag;
    }

    public String getBookingID() {
        return BookingID;
    }

    public String getBookingDate_Time() {
        return BookingDate_Time;
    }

    public String getReturnDate_Time() {
        return ReturnDate_Time;
    }

    public String getComputerType() {
        return ComputerType;
    }

    public String getComputerAssetTag() {
        return ComputerAssetTag;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "BookingID='" + BookingID + '\'' +
                ", BookingDate_Time='" + BookingDate_Time + '\'' +
                ", ReturnDate_Time='" + ReturnDate_Time + '\'' +
                ", ComputerType='" + ComputerType + '\'' +
                ", ComputerAssetTag='" + ComputerAssetTag + '\'' +
                '}';
    }
}
