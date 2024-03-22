package com.example.schoolpassport;

import javafx.scene.image.Image;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GoIn {
     public static ArrayList<GoIn> allGoIns;
    public String name;
    public String PerName;
    public int ID;
    public int grade;
    public String Advisor;

    public String Pronouns;
    public ChromeBook checkedOutChromeBook;
    public Image face;

    public GoIn(String name, String perName, int ID, int grade, String advisor, String pronouns, ChromeBook checkedOutChromeBook) {
        this.name = name;
        PerName = perName;
        this.ID = ID;
        this.grade = grade;
        Advisor = advisor;
        Pronouns = pronouns;
        this.checkedOutChromeBook = checkedOutChromeBook;
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

    public static ArrayList<GoIn> getAllGoIns() {
        return allGoIns;
    }

    public static void setAllGoIns(ArrayList<GoIn> allGoIns) {
        GoIn.allGoIns = allGoIns;
    }

    public void setPronouns(String pronouns) {
        Pronouns = pronouns;
    }

    public ChromeBook getCheckedOutChromeBook() {
        return checkedOutChromeBook;
    }

    public void setCheckedOutChromeBook(ChromeBook checkedOutChromeBook) {
        this.checkedOutChromeBook = checkedOutChromeBook;
    }

    public Image getFace() {
        return face;
    }

    public void setFace(Image face) {
        this.face = face;
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


    public void Save() throws Exception {
        FileOutputStream outputStream = new FileOutputStream("Save");
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);

        // Write the number of saved objects
        objOutputStream.writeInt(allGoIns.size());

        // Write each Activity object
        for (GoIn activity : allGoIns) {
            objOutputStream.writeObject(activity);
        }

        // Close the streams
        objOutputStream.flush();
        objOutputStream.close();
        outputStream.close();
    }
    public void reload() throws Exception {

        FileInputStream inputStream = new FileInputStream("Save");
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);

// Read the list size
        int numOfSavedObjects = objInputStream.readInt();

        allGoIns = new ArrayList<>();

// Read each Activity object
        for (int i = 0; i < numOfSavedObjects; i++) {
            GoIn activity = (GoIn) objInputStream.readObject();
            allGoIns.add(activity);
        }

// Close the streams
        objInputStream.close();
        inputStream.close();

    }
    static public void scanner() throws Exception {

        String fileName = "src/main/java/com/example/schoolpassport/SLA Roster - Students.tsv";

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

                    GoIn newPerson = new GoIn(name,PerName,iD,grade,advisor, pronouns, null);
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
