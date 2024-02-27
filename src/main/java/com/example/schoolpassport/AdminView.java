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
import java.util.ArrayList;
import java.util.List;

public class AdminView {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public TableView AdminTable;
    public DatePicker AdminDate;

    public LocalDate localDate;

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
    public void adminData() throws IOException {


       String dateString = AdminDate.getValue().toString();

        AdminTable.getItems().add(new GoIn("Eli", AdminDate.getValue(),"eliPhillip24",12.0,12.0,false,12));

    }
    public void initialize() {


        TableColumn NameColumn = new TableColumn<GoIn, String>("Name");
        NameColumn.setCellValueFactory(new PropertyValueFactory<GoIn, String>("name"));

        TableColumn DateColummn = new TableColumn<GoIn, LocalDate>("Date");
        DateColummn.setCellValueFactory(new PropertyValueFactory<GoIn, LocalDate>("date"));

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





    }
    public void normalMode(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }
}
