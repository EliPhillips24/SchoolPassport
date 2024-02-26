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

    public PasswordField Password;
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
        System.out.println(Password.getText());

        if (Password.getText() == "SLA2023"){

            root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    protected void addData() throws IOException {}
    protected void ReadData() throws IOException {}
    protected void Save() throws IOException {}
    protected void Restore() throws IOException {}
    protected void TakeFaceCameShot() throws IOException {}
    protected void pullFromItem() throws IOException {}
    protected void Initialize() throws IOException {}


    public void onHelloButtonClick(ActionEvent actionEvent) {

    }
}

