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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AdminView {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public TableView AdminTable;

    public LocalDate localDate;
    LocalDate currentDate = LocalDate.now();

    String currentDateString = currentDate.toString();

    String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());




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


        TableColumn TodaysDateColumn = new TableColumn<GoIn, Integer>("Date");
        TodaysDateColumn.setCellValueFactory(new PropertyValueFactory<GoIn, Integer>("date"));






        TableColumn AdvisorColumn = new TableColumn<GoIn, String>("Advisor");
        AdvisorColumn.setCellValueFactory(new PropertyValueFactory<GoIn, String>("advisor"));


        AdminTable.getColumns().add(NameColumn);
        AdminTable.getColumns().add(EmailColumn);
        AdminTable.getColumns().add(StuIDColumn);
        AdminTable.getColumns().add(GradyearColumn);
        AdminTable.getColumns().add(AdvisorColumn);
        AdminTable.getColumns().add(TodaysDateColumn);

        GoIn.scanner();
        for (GoIn eachOne : GoIn.allGoIns) {
            AdminTable.getItems().add(eachOne);
        }


    }
    public void normalMode(ActionEvent event) throws Exception {
        System.out.println("Normal Mode");
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }

}




