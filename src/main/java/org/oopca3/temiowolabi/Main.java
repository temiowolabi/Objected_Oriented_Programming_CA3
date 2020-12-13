package org.oopca3.temiowolabi;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

    public class Main
    {
        private static Scanner keyboard = new Scanner(System.in);
        public static void main( String[] args )
        {
            System.out.println( Colours.PURPLE + "Welcome to the Booking System." + Colours.RESET);
        Main bookingSystem = new Main();
            bookingSystem.start();
        }

        private void start()
        {
        StudentDB studentDB = new StudentDB();
        BookingDB bookingDB = new BookingDB();
        studentDB.loadStudentsFromFile();
        bookingDB.loadBookingsFromFile();
        doMainMenuLoop(studentDB, bookingDB);
        }

        private void doMainMenuLoop(StudentDB studentDB, BookingDB bookingDB)
        {
            boolean loop = true;
            MainMenu menuOption;
            int option;
            while(loop)
            {
                printMainMenu();
                try
                {
                    option = keyboard.nextInt();
                    keyboard.nextLine();
                    menuOption = MainMenu.values()[option];
                    switch(menuOption)
                    {
                        case QUIT_APPLICATION:
                            loop = false;
                            break;
                        case STUDENT_MENU:
                            doStudentsMainMenuLoop(studentDB);
                            break;
                        case BOOKING_MENU:
                            doBookingsMainMenuLoop(bookingDB);
                            break;
                    }
                }
                catch(InputMismatchException ime)
                {
                    System.out.println(Colours.RED + "Please enter a valid option" + Colours.RESET);
                    keyboard.nextLine();
                }
            }
            System.out.println(Colours.PURPLE + "Thanks for using the app" + Colours.RESET);
        }

        private void doStudentsMainMenuLoop(StudentDB studentDB)
        {
            boolean loop = true;
            StudentsMainMenu menuOption;
            int option;
            while(loop)
            {
                printStudentsMainMenu();
                try
                {
                    option = keyboard.nextInt();
                    keyboard.nextLine();
                    menuOption = StudentsMainMenu.values()[option];
                    switch (menuOption)
                    {
                        case QUIT_STUDENT_MENU:
                            loop = false;
                            break;
                        case ADD_STUDENT:
                            studentDB.addStudent();
                            break;
                        case DELETE_STUDENT:
                            studentDB.deleteStudent();
                            break;
                        case PRINT_STUDENT:
                            studentDB.printStudent();
                            break;
                    }
                }
                catch (InputMismatchException ime)
                {
                    System.out.println(Colours.RED + "InputMismatchException. The token retrieved does not match the pattern for the expected type. Please enter a valid option" + Colours.RESET);
                    keyboard.nextLine();
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println(Colours.RED + "ArrayIndexOutOfBoundsException. The index is either negative or greater than or equal to the size of the array." + Colours.RESET);
                    keyboard.nextLine();
                }
                catch (IllegalArgumentException e)
                {
                    System.out.println(Colours.RED + "IllegalArgumentException. A method has been passed an illegal argument. Try again" + Colours.RESET);
                    keyboard.nextLine();
                }

        }

        }



        private void doBookingsMainMenuLoop(BookingDB bookingDB)
        {
            boolean loop = true;
            BookingsMainMenu menuOption;
            int option;
            while (loop) {
                printBookingsMainMenu();
                try {
                    option = keyboard.nextInt();
                    keyboard.nextLine();
                    menuOption = BookingsMainMenu.values()[option];
                    switch (menuOption) {
                        case QUIT_BOOKING_MENU:
                            loop = false;
                            break;
                        case ADD_BOOKING:
                            bookingDB.addBooking();
                            break;
                        case PRINT_BOOKING:
                            bookingDB.printBooking();
                            break;
                        case PRINT_ALL_BOOKING:
                            bookingDB.printAllBookings();
                            break;
                        case DELETE_BOOKING:
                            bookingDB.deleteBooking();
                            break;
                        case AVERAGE_LENGTH:
                            bookingDB.getAverage();
                            break;
                        case BOOKINGS_IN_ORDER:
                            bookingDB.bookingsInAscendingOrder();
                            break;
                        case RETURN_BOOKING:
                            bookingDB.returnComputer();
                            break;
                    }
                } catch (InputMismatchException ime) {
                    System.out.println(Colours.RED + "InputMismatchException. The token retrieved does not match the pattern for the expected type. Please enter a valid option" + Colours.RESET);
                    keyboard.nextLine();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(Colours.RED + "ArrayIndexOutOfBoundsException. The index is either negative or greater than or equal to the size of the array." + Colours.RESET);
                    keyboard.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println(Colours.RED + "IllegalArgumentException. A method has been passed an illegal argument. Try again" + Colours.RESET);
                    keyboard.nextLine();
                }
            }
        }



        private void printStudentsMainMenu()
        {
            System.out.println("\n Select One The Following Options: ");
            for(int i=0; i < StudentsMainMenu.values().length;i++)
            {
                System.out.println("\t" + Colours.PURPLE + i + ". " + StudentsMainMenu.values()[i].toString() + Colours.RESET);
            }
            System.out.print("Enter a number to select option (enter 0 to quit):>");
        }

        public static void printBookingsMainMenu()
        {
            System.out.println("\n Select One The Following Options: ");
            for (int i = 0; i < BookingsMainMenu.values().length; i++)
            {
                System.out.println("\t" + Colours.PURPLE + i + ". " + BookingsMainMenu.values()[i].toString() + Colours.RESET);
            }
            System.out.println("Enter a number to select option (enter 0 to quit):>");//Don't allow duplicates, ID values unique
        }

        private void printMainMenu()
        {
            System.out.println("\n Options to select:");
            for(int i=0; i < MainMenu.values().length;i++)
            {
                System.out.println("\t" + Colours.PURPLE + i + ". " + MainMenu.values()[i].toString() + Colours.RESET);
            }
            System.out.print("Enter a number to select option (enter 0 to quit):>");
        }

}