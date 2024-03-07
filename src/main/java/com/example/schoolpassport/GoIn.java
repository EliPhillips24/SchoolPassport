package com.example.schoolpassport;

import java.time.LocalDate;

public class GoIn {

private String Name;
public String Mydate;
private String email;
private int StudentID;
private int GradYear;
private Boolean Chromebook;
private int NumberOfChromebook;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMydate() {
        return Mydate;
    }

    public void setMydate(String mydate) {
        Mydate = mydate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public int getGradYear() {
        return GradYear;
    }

    public void setGradYear(int gradYear) {
        GradYear = gradYear;
    }

    public Boolean getChromebook() {
        return Chromebook;
    }

    public void setChromebook(Boolean chromebook) {
        Chromebook = chromebook;
    }

    public int getNumberOfChromebook() {
        return NumberOfChromebook;
    }

    public void setNumberOfChromebook(int numberOfChromebook) {
        NumberOfChromebook = numberOfChromebook;
    }

    public GoIn(String name, String mydate, String email, int studentID, int gradYear, boolean chromebook, int numberOfChromebook) {
        Name = name;
        Mydate = mydate;
        this.email = email;
        StudentID = studentID;
        GradYear = gradYear;
        Chromebook = chromebook;
        NumberOfChromebook = numberOfChromebook;
    }

    @Override
    public String toString() {
        return "GoIn" +
                "Name='" + Name + '\'' +
                ", Mydate=" + Mydate +
                ", email='" + email + '\'' +
                ", StudentID=" + StudentID +
                ", GradYear=" + GradYear +
                ", Chromebook=" + Chromebook +
                ", NumberOfChromebook=" + NumberOfChromebook +
                '}';
    }
}
