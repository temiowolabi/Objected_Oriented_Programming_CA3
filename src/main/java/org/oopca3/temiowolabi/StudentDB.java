package org.oopca3.temiowolabi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDB {

    private ArrayList<Student> studentList;

    public StudentDB()
    {
        this.studentList = new ArrayList<>();
    }

    public Student findStudentByStudentNumber(String studentNumber) {
        for(Student s : studentList ) {
            if(s.getStudentNumber().equals(studentNumber))
                return s;
        }
        return null;    // not found
    }

    /*Link used for information on avoiding duplicates.*/
//    https://stackoverflow.com/questions/19013855/java-avoid-inserting-duplicate-in-arraylist
    public void addStudent( Student s) {
        if(!studentList.contains(s)) //Checks if student number is in list before adding it. In reality it's checking for the whole list but the override methods in "Student Class", makes it only check the Student Number.
        {
            studentList.add( s ); //If student number is unique, the student will be added.
        }
        else
        {
            System.out.println(Colours.RED + "Duplicate Found. Student Numbers must be unique. Try again." + Colours.RESET); //If student number is NOT unique,
                                                                                                                            // this message will display and the student number will not be displayed.
        }
        //studentList.add( s );
    }

    public void removeStudentById( String studentNumber ) {
        Student student = findStudentByStudentNumber( studentNumber );    //TODO check for null id
        if( student != null)
            studentList.remove(student);

    }

    public void loadStudentsFromFile() {
        // open 'students.txt' file
        // read records and instantiate new Student objects
        // add each new student object to studentList
        // end.

        // Could initially hardcode some values here instead of reading from file
        // studentList.add( new Student("D012","Frank","1998-10-26"));
        //  etc - hard code more values


        try {
            Scanner sc = new Scanner(new File("student_data.txt"));

            while (sc.hasNext()) {


                String fName = sc.next();
                String sName = sc.next();
                String studentNumber = sc.next();
                String email = sc.next();
                String telephone = sc.next();
                String computerOnLoan = sc.next();

                //System.out.println("First Name: " + fName + " Surname: " + sName + " Student Number: " + studentNumber + " Email: " + email+ " Telephone: " + telephone + " Computer On Loan: " + computerOnLoan);
                //System.out.println("Name: " + name + " Student Number: " + studentNumber + " Email: " + email+ " Telephone: " + telephone + " Computer On Loan: " + computerOnLoan);
                studentList.add( new Student(fName, sName, studentNumber,  email, telephone, computerOnLoan));

            }
            sc.close();
            System.out.println("All Students: \n" + studentList); // print them all


        } catch (IOException e) {
            System.out.println("IOException thrown in loadStudentsFromFile() "+e.getMessage());
        }

    }

    public void getStudentByStudentNumber(String studentNumber)
    {

    }



}
