package org.oopca3.temiowolabi;

public class Student
{
    private String name;
    private String studentNumber;
    private String email;
    private String telephone;
    private String computerOnLoan;

    public Student(String name, String studentNumber, String email, String telephone, String computerOnLoan)
    {
        this.name = name;
        this.studentNumber = studentNumber;
        this.email = email;
        this.telephone = telephone;
        this.computerOnLoan = computerOnLoan;
    }

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
        return "student{" +
                "name='" + name + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", computerOnLoan='" + computerOnLoan + '\'' +
                '}';
    }
}
