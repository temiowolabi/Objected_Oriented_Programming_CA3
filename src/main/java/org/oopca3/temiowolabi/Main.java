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
        studentDb.loadStudentsFromFile();


    }
}