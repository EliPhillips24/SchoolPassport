package com.example.schoolpassport;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import com.github.sarxos.webcam.Webcam;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    public Label welcomeText;

    public TextField StudentID;

    public PasswordField passwordField;
    public TextField Date;
    public TextField DateOfBirth;
    public TextField AudioID;
    public ListView Chromebook;
    public Button Swap;
    @FXML

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void adminMode(ActionEvent event) throws Exception {
    String pass = passwordField.getText();
    if (pass.toString().equals("SLA2024")) {
        root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }else{
        PasswordIssue();
    }
    }



    public void PasswordIssue(){
        //Creating a dialog
        Dialog<String> dialog = new Dialog<String>();
        //Setting the title
        dialog.setTitle("Wrong Password");
        ButtonType type = new ButtonType("Return", ButtonBar.ButtonData.OK_DONE);
        //Setting the content of the dialog
        dialog.setContentText("Wrong Password");
        //Adding buttons to the dialog pane
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();

    }
    protected void addData() throws IOException {}
    protected void ReadData() throws IOException {}
    protected void Save() throws IOException {}
    protected void Restore() throws IOException {}
    protected void TakeFaceCameShot() throws IOException {}
    protected void pullFromItem() throws IOException {}
    protected void initialize() throws IOException {

    }


    public void onHelloButtonClick(ActionEvent actionEvent) {

    }
}

