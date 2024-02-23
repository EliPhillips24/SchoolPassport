package com.example.schoolpassport;

import javafx.scene.image.Image;

import java.time.LocalDate;

public class IdentificationCard {

    private final int image;

    public IdentificationCard(String name, int id, LocalDate mydob, String graduationyr, int image) {
        this.name = name;
        this.id = id;
        this.mydob = mydob;
        this.graduationyr = graduationyr;
        this.image=image;
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

    public int getImage() {return image;}



    private LocalDate mydob;

    private String graduationyr;


}
