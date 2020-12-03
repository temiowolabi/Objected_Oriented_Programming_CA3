package org.oopca3.temiowolabi;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    public void start()
    {
        StudentDB studentDb = new StudentDB();
        studentDb.addStudent( new Student("Temi","Owolabi","D00227197", "D00227197@student.dkit.ie", "089 427 3427", "Null"));
        studentDb.addStudent( new Student("Temi","Owolabi","D00227193", "D00227197@student.dkit.ie", "089 427 3427", "Null"));
        studentDb.addStudent( new Student("Santos","Odigie","D00233649", "D00233649@student.dkit.ie", "089 427 3427", "Null"));


        studentDb.loadStudentsFromFile();

//
//        ComputerDB computerDb = new ComputerDB();
//        computerDb.addComputer(new Laptop("Dell", "intel core i5", 8,120,2, "idk", "2020-11-18", 13, 4));
//
//        computerDb.getComputerById("ID12903");
    }
}