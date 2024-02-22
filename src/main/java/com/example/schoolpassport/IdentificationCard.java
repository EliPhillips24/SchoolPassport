package com.example.schoolpassport;

import java.time.LocalDate;

public class IdentificationCard {

    public IdentificationCard(String name, int id, LocalDate mydob, String graduationyr) {
        this.name = name;
        this.id = id;
        this.mydob = mydob;
        this.graduationyr = graduationyr;
    }
    private String name;

    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public LocalDate getMydob() {
        return mydob;
    }

    public String getGraduationyr() {
        return graduationyr;
    }

    private LocalDate mydob;

    private String graduationyr;


}
