package com.example.schoolpassport;

import java.util.ArrayList;

public class GoIn {
    static ArrayList<GoIn> allGoIns;
    public String name;
    public String PerName;
    public int ID;
    public int grade;
    public String Advisor;

    public String Pronouns;

    public GoIn(String name, String perName, String pronouns, int id, int grade, String advisor) {
        this.name = name;
        PerName = perName;
        this.ID = id;
        this.grade = grade;
        Advisor = advisor;
        Pronouns = pronouns;
        if (allGoIns == null) {
            allGoIns = new ArrayList<GoIn>();
        }
        allGoIns.add(this);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerName() {
        return PerName;
    }

    public void setPerName(String perName) {
        PerName = perName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    public String getAdvisor() {
        return Advisor;
    }

    public void setAdvisor(String advisor) {
        Advisor = advisor;
    }
    public String getPronouns() {
        return Pronouns;
    }

    public void setPronoun(String pronouns) {
        Pronouns = pronouns;
    }

    @Override
    public String toString() {
        return "GoIn{" +
                "name='" + name + '\'' +
                ", PerName='" + PerName + '\'' +
                ", ID=" + ID +
                ", grade=" + grade +
                ", Advisor='" + Advisor + '\'' +
                ", Pronoun='" + Pronouns + '\'' +
                '}';
    }
}
