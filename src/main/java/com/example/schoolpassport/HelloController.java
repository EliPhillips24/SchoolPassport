package com.example.schoolpassport;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import com.github.sarxos.webcam.Webcam;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    public Label welcomeText;

    public TextField StudentID;
    public TextField Date;
    public TextField DateOfBirth;
    public TextField AudioID;
    public ListView Chromebook;
    @FXML
    protected void onHelloButtonClick() throws IOException {
        String name = "Eli";

        String dateString = DateOfBirth.getText();  // Get the date of birth from the TextField

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy,MM,dd");
        LocalDate myDate = LocalDate.parse(dateString, formatter);

        String email = "kingfisheiei@gmail.com";
        Double studentID = 12.0;
        Double gradYear = 2.0;
        Boolean chromebook = false;
        int numberOfChromebook = 2;

        GoIn goInInstance = new GoIn(name, myDate, email, studentID, gradYear, chromebook, numberOfChromebook);
        System.out.println(goInInstance.toString());

    }
}

