package org.oopca3.temiowolabi;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class BookingDB
{
    private ArrayList<Booking> bookingList;
    private static Scanner keyboard = new Scanner(System.in);

    public BookingDB() {
        this.bookingList = new ArrayList<>();
    }

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
            System.out.println("Can't find the file. Try again. "+fne.getMessage());
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


    public void getAverage()
    {
        LocalDateTime start;
        LocalDateTime end;

        double averageValue = 0;
        double sum = 0;

        if (bookingList.size() > -1) {
            for (Booking booking : bookingList) {
                start = booking.getBookingTimeDate();
                end = booking.getReturnTimeDate();

                long difference = Duration.between(start, end).toSeconds();

                long secsInMin = 60;
                long secsInHour = 60 * 60;
                long secsInDay = 60 * 60 * 24;

                long days = difference / secsInDay;   // integer division
                long daysDivisionResidueMillis = difference - (days * secsInDay); // subtract days to get remaining hours

                long hours = daysDivisionResidueMillis / secsInHour;
                long hoursDivisionResidueMillis = daysDivisionResidueMillis - (hours * secsInHour);

                long minutes = hoursDivisionResidueMillis / secsInMin;
                long minutesDivisionResidueMillis = hoursDivisionResidueMillis - (minutes * secsInMin);


                sum = days + hours + minutes;

            }
            averageValue = (sum / (double)bookingList.size());

        }
        System.out.printf("Average length of bookings: %.2f", averageValue);
    }

    public void bookingsInAscendingOrder()
    {
        datesInAscendingOrder inOrder = new datesInAscendingOrder();

        Collections.sort(bookingList, inOrder);
        System.out.println(bookingList);
    }

    public void returnComputer()
    {
        System.out.println("Enter ID to print:> ");
        String studentNumber = keyboard.nextLine();
        Student student = findBooking(studentNumber);
        System.out.println(student);

        Booking booking = new Booking();

        LocalDateTime now = LocalDateTime.now();

        booking.setReturnTimeDate(now);


    }
    }



