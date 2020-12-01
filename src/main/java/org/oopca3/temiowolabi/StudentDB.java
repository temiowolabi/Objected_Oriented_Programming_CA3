package org.oopca3.temiowolabi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDB {

    private ArrayList<Student> studentList;

    public StudentDB() {
        this.studentList = new ArrayList<>();
    }

    public Student findStudentById(String id) {
        for(Student s : studentList ) {
            if(s.getStudentNumber().equals(id))
                return s;
        }
        return null;    // not found
    }

    public void addStudent( Student s) {    //TODO prevent duplicates
        studentList.add( s );
    }

    public void removeStudentById( String id ) {
        Student student = findStudentById( id );    //TODO check for null id
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


        System.out.println("Reading student DB from file...");

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
            System.out.println("All students loaded");
            sc.close();
            System.out.println("All Students: " + studentList); // print them all


        } catch (IOException e) {
            System.out.println("IOException thrown in loadStudentsFromFile() "+e.getMessage());
        }

    }



}
