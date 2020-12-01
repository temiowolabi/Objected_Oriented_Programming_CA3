package org.oopca3.temiowolabi;

import java.util.Objects;

public class Student
{
    private String fName;
    private String sName;
    private String studentNumber;
    private String email;
    private String telephone;
    private String computerOnLoan;

    public Student(String fName, String SName, String studentNumber, String email, String telephone, String computerOnLoan)
    {
        this.fName = fName;
        this.sName = SName;
        this.studentNumber = studentNumber;
        this.email = email;
        this.telephone = telephone;
        this.computerOnLoan = computerOnLoan;
    }

    public String getfName() {
        return fName;
    }

    public String getsName() {
        return sName;
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
        return '\n' + "Student Information: " +
                "First Name = " + fName +
                " Surname = " + sName  +
                " Student Number = " + studentNumber  +
                " Email = " + email +
                " Telephone = " + telephone +
                " Computer On Loan = " + computerOnLoan + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(fName, student.fName) &&
                Objects.equals(sName, student.sName) &&
                Objects.equals(studentNumber, student.studentNumber) &&
                Objects.equals(email, student.email) &&
                Objects.equals(telephone, student.telephone) &&
                Objects.equals(computerOnLoan, student.computerOnLoan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fName, sName, studentNumber, email, telephone, computerOnLoan);
    }
}
