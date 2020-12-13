package org.oopca3.temiowolabi;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingDB
{
    private ArrayList<Booking> bookingList;
    private static Scanner keyboard = new Scanner(System.in);

    public BookingDB() {
        this.bookingList = new ArrayList<>();
    }

//    public void addBooking (String studentNumber, String computerID) //don't forget to add date of booking. Can use LocalDateTime thing for current date.
//    {
//        Booking newBooking = new Booking();
//        bookingList.add( newBooking );
//    }

    public void loadBookingsFromFile() {

        try(Scanner sc = new Scanner(new BufferedReader(new FileReader("booking.txt"))))
        {
            String input;
            while(sc.hasNextLine())
            {
                input = sc.nextLine();
                String[] data = input.split(",");
                String bookingID = data[0];
                String bookingTimeDate = data[1];
                String returnTimeDate = data[2];
                String computerType = data[3];
                String assertTag = data[4];
                String studentNumber = data[5];

                Booking readInPlayer = new Booking(bookingID, bookingTimeDate, returnTimeDate, computerType, assertTag, studentNumber);
                this.bookingList.add(readInPlayer);
            }

        } catch (FileNotFoundException fne) {
            System.out.println("IOException thrown in loadBookingsFromFile() "+fne.getMessage());
        }

    }

    public void saveBookingsToFile()
    {
        try(BufferedWriter studentsFile = new BufferedWriter(new FileWriter("booking.txt") ))
        {
            for(Booking booking : bookingList)
            {
                studentsFile.write(booking.getBookingID()+","+booking.getBookingTimeDate()+","+booking.getReturnTimeDate()+","+booking.getComputerType() +","+booking.getAssertTag()+","+booking.getStudentNumber() );
                studentsFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
            System.out.println(Colours.BLUE + "Could not save students." +Colours.RESET);
        }
    }

    public static void printBookingMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < BookingsMainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + BookingsMainMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.println("Enter a number to select option (enter 0 to cancel):>");
    }


    public void addBooking()
    {

        String bookingID = enterField("Booking ID");
        String bookingTimeDate = enterField("Booking Date & Time");
        String returnTimeDate = enterField("Return Date & Time");
        String computerType = enterField("Computer Type");
        String assertTag = enterField("Assert Tag");
        String studentNumber = enterField("Student Number");
        Booking addition = new Booking(bookingID, bookingTimeDate, returnTimeDate, computerType, assertTag, studentNumber);
        if(!bookingList.contains(addition)) //Checks if student number is in list before adding it. In reality it's checking for the whole list but the override methods in "Student Class", makes it only check the Student Number.
        {
            bookingList.add( addition ); //If student number is unique, the student will be added.
        }
        else
        {
            System.out.println(Colours.RED + "Duplicate Found. There is already a booking under this ID. Try again." + Colours.RESET); //If student number is NOT unique,
            // this message will display and the student number will not be displayed.
        }
       // bookingList.add(addition);
    }

    public void printAllBookings()
    {
        try(Scanner sc = new Scanner(new BufferedReader(new FileReader("booking.txt"))))
        {
            String input;
            while(sc.hasNextLine())
            {
                input = sc.nextLine();
                String[] data = input.split(",");
                String bookingID = data[0];
                String bookingTimeDate = data[1];
                String returnTimeDate = data[2];
                String computerType = data[3];
                String assertTag = data[4];
                String studentNumber = data[5];

                Booking readInPlayer = new Booking(bookingID, bookingTimeDate, returnTimeDate, computerType, assertTag, studentNumber);
                this.bookingList.add(readInPlayer);
            }
            System.out.println("All Bookings: \n" + bookingList);
        } catch (IOException e) {
            System.out.println("IOException thrown in loadBookingsFromFile() "+e.getMessage());
        }
    }

    private String enterField(String field)
    {
        String input;
        System.out.println("Enter Student " + field + ":> ");
        input = keyboard.nextLine();
        return input;
    }

    public void deleteBooking()
    {
        System.out.println("Enter ID to delete:> ");
        String studentNumber = keyboard.nextLine();
        Student bookingToRemove = findBooking(studentNumber);
        bookingList.remove(bookingToRemove);
    }

    public void printBooking()
    {
        System.out.println("Enter ID to print:> ");
        String studentNumber = keyboard.nextLine();
        Student student = findBooking(studentNumber);
        System.out.println(student);
    }

    private Student findBooking(String studentNumber)
    {
        for(Booking booking : bookingList)
        {
            if(booking.getStudentNumber().equals(studentNumber))
            {
                return booking;
            }
        }
        return null;
    }



    public void returnComputer (String studentNumber, String computerID)
    {
        
    }
}
