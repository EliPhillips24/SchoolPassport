package com.example.schoolpassport;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AdminView {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public TableView AdminTable;
    public DatePicker AdminDate;

    public LocalDate localDate;

    public  String date;

    public void Save() throws Exception {

            FileOutputStream outputStream = new FileOutputStream("Save");
            ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);

            ObservableList<GoIn> activities = AdminTable.getItems();

            // Write the number of saved objects
            objOutputStream.writeInt(activities.size());

            // Write each Activity object
            for (GoIn activity : activities) {
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

        List<GoIn> activities = new ArrayList<>();

// Read each Activity object
        for (int i = 0; i < numOfSavedObjects; i++) {
            GoIn activity = (GoIn) objInputStream.readObject();
            activities.add(activity);
        }

// Close the streams
        objInputStream.close();
        inputStream.close();

// Add the loaded activities to the table
        AdminTable.getItems().addAll(activities);
    }

    protected void adminRemove() throws IOException {}
    public void adminData() throws Exception {

        String date = AdminDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
           System.out.println(date);


        this.scanner();

    }
    public void initialize() throws Exception {


        TableColumn NameColumn = new TableColumn<GoIn, String>("Name");
        NameColumn.setCellValueFactory(new PropertyValueFactory<GoIn, String>("name"));

        TableColumn DateColummn = new TableColumn<GoIn, LocalDate>("Date");
        DateColummn.setCellValueFactory(new PropertyValueFactory<GoIn, LocalDate>("Mydate"));

        TableColumn EmailColumn = new TableColumn<GoIn, String>("Email");
        EmailColumn.setCellValueFactory(new PropertyValueFactory<GoIn, String>("email"));

        TableColumn StuIDColumn = new TableColumn<GoIn, Double>("StudentID");
        StuIDColumn.setCellValueFactory(new PropertyValueFactory<GoIn, Double>("studentID"));

        TableColumn GradyearColumn = new TableColumn<GoIn, Double>("GradYear");
        GradyearColumn.setCellValueFactory(new PropertyValueFactory<GoIn, Double>("gradYear"));

        TableColumn ChromebookColumn = new TableColumn<GoIn, Boolean>("Chromebook");
        ChromebookColumn.setCellValueFactory(new PropertyValueFactory<GoIn, Boolean>("chromebook"));

        TableColumn ChromebookNum = new TableColumn<GoIn, Integer>("NumberOfChromebook");
        ChromebookNum.setCellValueFactory(new PropertyValueFactory<GoIn, Integer>("numberOfChromebook"));



        AdminTable.getColumns().add(NameColumn);
        AdminTable.getColumns().add(DateColummn);
        AdminTable.getColumns().add(EmailColumn);
        AdminTable.getColumns().add(StuIDColumn);
        AdminTable.getColumns().add(GradyearColumn);
        AdminTable.getColumns().add(ChromebookColumn);
        AdminTable.getColumns().add(ChromebookNum);

//scanner






    }
    public void normalMode(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }


    public void scanner() throws Exception {
/*
        String fileName = "/Users/elip/IdeaProjects/SchoolPassport/src/main/java/com/example/schoolpassport/SLA Roster - Students.tsv";

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
                    String pronouns = components[1];
                    String id = components[2];
                    int grade = Integer.parseInt(components[3]);


                    int classroom;
                    try {
                        classroom = Integer.parseInt(components[4]);
                    } catch (NumberFormatException e) {
                        // Handle the case where the value cannot be parsed as an integer
                        // You might want to set a default value or log the error
                        classroom = 0; // Default value, replace with your logic
                    }



                    try {
                        classroom = Integer.parseInt(components[4]);
                    } catch (NumberFormatException e) {
                        // Handle the case where the value cannot be parsed as an integer
                        // You might want to set a default value or handle it in another way
                        classroom = 0; // Default value, replace with your logic
                    }

                    String advisor = components[5];

                    // Process the extracted information (replace this with your logic)
                    System.out.println("Name: " + name);
                    System.out.println("Pronouns: " + pronouns);
                    System.out.println("ID: " + id);
                    System.out.println("Grade: " + grade);
                    System.out.println("Classroom: " + classroom);
                    System.out.println("Advisor: " + advisor);
                    System.out.println("-----------------------");
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }

            // Close the Scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("File not found: " + fileName);
        }

 */
            }



        }




