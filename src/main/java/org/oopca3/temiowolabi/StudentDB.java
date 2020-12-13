package org.oopca3.temiowolabi;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDB {

    private ArrayList<Student> studentList;
    private static Scanner keyboard = new Scanner(System.in);

    public StudentDB()
    {
        this.studentList = new ArrayList<>();
    }

    public void loadStudentsFromFile() {

        try(Scanner studentsFile = new Scanner(new BufferedReader(new FileReader("students_data.txt"))))
        {
            String input;
            while(studentsFile.hasNextLine())
            {
                input = studentsFile.nextLine();
                String[] data = input.split(",");
                String name = data[0];
                String studentNumber = data[1];
                String email = data[2];
                String telephone = data[3];
                String computerOnLoan = data[4];

                Student readInPlayer = new Student(name, studentNumber, email, telephone, computerOnLoan);
                this.studentList.add(readInPlayer);
            }
        } catch (FileNotFoundException fne) {
            System.out.println("Can't find the file. Try again. "+fne.getMessage());
        }

    }

    public void saveStudentsToFile()
    {
        try(BufferedWriter studentsFile = new BufferedWriter(new FileWriter("students_data.txt") ))
        {
            for(Student student : studentList)
            {
                studentsFile.write(student.getName() +","+student.getStudentNumber()+","+student.getEmail()+","+student.getTelephone() +","+student.getComputerOnLoan() );
                studentsFile.write("\n");
            }
        }
        catch(IOException ioe)
        {
                System.out.println(Colours.BLUE + "Could not save students." +Colours.RESET);
        }
    }

    public static void printStudentMainMenu()
    {
        System.out.println("\n Options to select:");
        for(int i=0; i < StudentsMainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + StudentsMainMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.println("Enter a number to select option (enter 0 to cancel):>");
    }


    public void addStudent()
    {
        String name = enterField("Student Name");
        String studentNumber = enterField("Student Number");
        String email = enterField("Email");
        String telephone = enterField("Telephone");
        String computerOnLoan = enterField("Computer On Loan");
        Student addition = new Student(name, studentNumber, email, telephone, computerOnLoan);
        if(!studentList.contains(addition)) //Checks if student number is in list before adding it. In reality it's checking for the whole list but the override methods in "Student Class", makes it only check the Student Number.
        {
            studentList.add( addition ); //If student number is unique, the student will be added.
        }
        else
        {
            System.out.println(Colours.RED + "Duplicate Found. Student Numbers must be unique. Try again." + Colours.RESET); //If student number is NOT unique,
            // this message will display and the student number will not be displayed.
        }
       // studentList.add(addition);
    }


    private String enterField(String field)
    {
        String input;
        System.out.println("Enter Student " + field + ":> ");
        input = keyboard.nextLine();
        return input;
    }

    public void deleteStudent()
    {
        System.out.println("Enter ID to delete:> ");
        String studentNumber = keyboard.nextLine();
        Student studentToRemove = findStudent(studentNumber);
        studentList.remove(studentToRemove);
    }

    public void printStudent()
    {
        System.out.println("Enter ID to print:> ");
        String studentNumber = keyboard.nextLine();
        Student student = findStudent(studentNumber);
        System.out.println(student);
    }

    private Student findStudent(String studentNumber)
    {
        for(Student student : studentList)
        {
            if(student.getStudentNumber().equals(studentNumber))
            {
                return student;
            }
        }
        return null;
    }




}
