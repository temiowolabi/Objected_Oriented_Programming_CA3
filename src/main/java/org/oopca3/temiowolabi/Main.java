package org.oopca3.temiowolabi;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    public void start() {
        readStudentsFromFile();
        readBookingFromFile();
//        displayStudentDetails(students);
    }

    private void readStudentsFromFile() {
        //Use try with resources and BufferedReader
        try (Scanner studentFile = new Scanner(new BufferedReader(new FileReader("student_data.txt")))) {
            while (studentFile.hasNextLine()) {
                String input = studentFile.nextLine();
                System.out.println(input);
            }
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        }
    }

    private void writeNewStudent() {
        FileWriter newStudent = null;
        try {
            newStudent = new FileWriter("student_data.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readBookingFromFile() {
        //Use try with resources and BufferedReader
        try (Scanner studentFile = new Scanner(new BufferedReader(new FileReader("booking.txt")))) {
            while (studentFile.hasNextLine()) {
                String input = studentFile.nextLine();

                System.out.println(input);
            }
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        }
    }
}