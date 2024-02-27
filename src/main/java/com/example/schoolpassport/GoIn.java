package com.example.schoolpassport;

import java.time.LocalDate;

public class GoIn {

private String Name;
private LocalDate Mydate;
private String email;
private Double StudentID;
private Double GradYear;
private Boolean Chromebook;
private int NumberOfChromebook;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDate getMydate() {
        return Mydate;
    }

    public void setMydate(LocalDate mydate) {
        Mydate = mydate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getStudentID() {
        return StudentID;
    }

    public void setStudentID(Double studentID) {
        StudentID = studentID;
    }

    public Double getGradYear() {
        return GradYear;
    }

    public void setGradYear(Double gradYear) {
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

    public GoIn(String name, LocalDate mydate, String email, Double studentID, Double gradYear, Boolean chromebook, int numberOfChromebook) {
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
