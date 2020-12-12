package org.oopca3.temiowolabi;

import java.util.Objects;

public class Student
{
    //    private String fName;
//    private String sName;
    private String name;
    private String studentNumber;
    private String email;
    private String telephone;
    private String computerOnLoan;

    public Student(String name, String studentNumber, String email, String telephone, String computerOnLoan)
    {
//        this.fName = fName;
//        this.sName = SName;
        this.name = name;
        this.studentNumber = studentNumber;
        this.email = email;
        this.telephone = telephone;
        this.computerOnLoan = computerOnLoan;
    }

    public Student() {

    }

//    public String getfName() {
//        return fName;
//    }
//
//    public String getsName() {
//        return sName;
//    }


    public String getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getComputerOnLoan() {
        return computerOnLoan;
    }

    @Override
    public String toString() {
        return '\n' + "Student Information: " + '\n' +
                " Student Name = " + name + '\n' +
                " Student Number = " + studentNumber  + '\n' +
                " Email = " + email + '\n' +
                " Telephone = " + telephone + '\n' +
                " Computer On Loan = " + computerOnLoan + '\n';
    }

    //Checking if the student numbers are equal.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentNumber, student.studentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNumber);
    }
}
