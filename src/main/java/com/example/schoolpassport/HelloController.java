package com.example.schoolpassport;

import java.io.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

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
    public ImageView studentFace;
    @FXML

    private Stage stage;
    private Scene scene;
    private Parent root;

    // state of the app
    GoIn currentUser;

    protected void initialize() throws Exception {
        GoIn.scanner();
        ChromeBook chromeBook1 = new ChromeBook(1, null,null);
        ChromeBook chromeBook2 = new ChromeBook(1, null,null);
        ChromeBook chromeBook3 = new ChromeBook(1, null,null);
        ChromeBook chromeBook4 = new ChromeBook(1, null,null);
        ChromeBook chromeBook5 = new ChromeBook(1, null,null);
    }


    @FXML
    public void adminMode(ActionEvent event) throws Exception {
        System.out.println(Password.getText());

        if (Password.getText().equals("SLA2024")) {
            System.out.println("True");

            root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void checkInOutChromebook() {
        // Tahseen will work here
        if (currentUser.getCheckedOutChromeBook() != null) {


        }
    }

    public void login() {
        // Rohan will work here

        currentUser = GoIn.allGoIns.get(0);
        currentUser.setCheckedOutChromeBook(ChromeBook.allChromeBooks.get(0));
    }

    public void uploadPicture(ActionEvent actionEvent) throws Exception {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        FileInputStream input = new FileInputStream(selectedFile);
        Image image = new Image(input);
        studentFace.setImage(image);
    }
}

