package com.example.schoolpassport;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GoIn {
    static public ArrayList<GoIn> allGoIns;
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

    static public void scanner() throws Exception {

        String fileName = "/Users/TahseenAyesh/IdeaProjects/MyFirstTableView/SchoolPassport/src/main/java/com/example/schoolpassport/SLA Roster - Students.tsv";

        try {
            // Create a Scanner to read from the file
            Scanner scanner = new Scanner(new File(fileName));

            // Loop through each line in the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Split the line into individual components
                String[] components = line.split("\t");

                // Ensure the line has enough components to extract information
                if (components.length >= 6) {
                    String name = components[0];
                    String PerName = components[1];
                    String pronouns = components[2];
                    int iD = Integer.parseInt(components[3]);
                    int grade = Integer.parseInt(components[4]);

                    String advisor = components[5];

                    System.out.println(iD);
                    GoIn newPerson = new GoIn(name,PerName,pronouns,iD,grade,advisor);
                    System.out.println("id");

                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File not found: " + fileName);
        }
    }
}
