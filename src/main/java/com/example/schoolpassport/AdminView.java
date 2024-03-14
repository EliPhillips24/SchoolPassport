package com.example.schoolpassport;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminView {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public TableView AdminTable;

    public LocalDate localDate;

    public  String date;

    public TextField idTextField;

    public void Save() throws Exception {

            FileOutputStream outputStream = new FileOutputStream("Save");
            ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);

            ObservableList<GoIn> activities = AdminTable.getItems();

            objOutputStream.writeInt(activities.size());

            for (GoIn activity : activities) {
                objOutputStream.writeObject(activity);
            }

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
    public void adminData(ActionEvent event) {
        String idText = idTextField.getText();
        int id = Integer.parseInt(idText);

        GoIn result = getIndex(id);

        System.out.println(result);
        System.out.println("name" );

    }
    public void initialize() throws Exception {

        TableColumn NameColumn = new TableColumn<GoIn, String>("Name");
        NameColumn.setCellValueFactory(new PropertyValueFactory<GoIn, String>("name"));

        TableColumn EmailColumn = new TableColumn<GoIn, String>("PerName");
        EmailColumn.setCellValueFactory(new PropertyValueFactory<GoIn, String>("perName"));

        TableColumn StuIDColumn = new TableColumn<GoIn, String>("Pronouns");
        StuIDColumn.setCellValueFactory(new PropertyValueFactory<GoIn, String>("pronouns"));

        TableColumn GradyearColumn = new TableColumn<GoIn, Integer>("Ident");
        GradyearColumn.setCellValueFactory(new PropertyValueFactory<GoIn, Integer>("iD"));

        TableColumn AdvisorColumn = new TableColumn<GoIn, String>("Advisor");
        AdvisorColumn.setCellValueFactory(new PropertyValueFactory<GoIn, String>("advisor"));

        AdminTable.getColumns().add(NameColumn);
        AdminTable.getColumns().add(EmailColumn);
        AdminTable.getColumns().add(StuIDColumn);
        AdminTable.getColumns().add(GradyearColumn);
        AdminTable.getColumns().add(AdvisorColumn);

        this.scanner();

    }
    public void normalMode(ActionEvent event) throws Exception {
        System.out.println("Normal Mode");
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

public  GoIn getIndex(int id){
    for (GoIn goIn : GoIn.allGoIns) {

        if (goIn.ID == id ){
            return goIn;
        }
    }

    return null;

}


    public void scanner() throws Exception {

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
                    String PerName = components[1];
                    String pronouns = components[2];
                    int iD = Integer.parseInt(components[3]);
                    int grade = Integer.parseInt(components[4]);

                    String advisor = components[5];

                    System.out.println(iD);
                    GoIn newPerson = new GoIn(name,PerName,pronouns,iD,grade,advisor);
                        AdminTable.getItems().add(newPerson);
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




