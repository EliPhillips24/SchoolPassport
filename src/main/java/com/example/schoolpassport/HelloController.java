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
    protected void adminMode() throws IOException {}
    protected void addData() throws IOException {}
    protected void ReadData() throws IOException {}
    protected void Save() throws IOException {}
    protected void Restore() throws IOException {}
    protected void addminRemove() throws IOException {}
    protected void TakeFaceCameShot() throws IOException {}
    protected void pullFromItem() throws IOException {}



}

