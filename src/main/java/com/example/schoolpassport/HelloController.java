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
    public PasswordField Password;
    public TextField studentID;
    public TextField studentName;

    public TextField Date;
    public TextField DateOfBirth;
    public TextField AutoID;
    public ListView Chromebooks;
    public Button CheckInOutButton;
    public ImageView studentFace;
    @FXML

    private Stage stage;
    private Scene scene;
    private Parent root;

    // state of the app
    GoIn currentUser;

    public void initialize() throws Exception {
        GoIn.scanner();
        ChromeBook chromeBook1 = new ChromeBook(1, null,null);
        ChromeBook chromeBook2 = new ChromeBook(2, null,null);
        ChromeBook chromeBook3 = new ChromeBook(3, null,null);
        ChromeBook chromeBook4 = new ChromeBook(4, null,null);
        ChromeBook chromeBook5 = new ChromeBook(5, null,null);
        Chromebooks.getItems().add(chromeBook1);
        Chromebooks.getItems().add(chromeBook2);
        Chromebooks.getItems().add(chromeBook3);
        Chromebooks.getItems().add(chromeBook4);
        Chromebooks.getItems().add(chromeBook5);
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
        if (currentUser.getCheckedOutChromeBook() == null) {

            // the user wants to check out a chromebook
            ChromeBook selectedChrombook = (ChromeBook)Chromebooks.getSelectionModel().getSelectedItem();
            currentUser.setCheckedOutChromeBook(selectedChrombook);
            selectedChrombook.setWhoCheckedOut(currentUser);
            CheckInOutButton.setText("Check Back In");
            Chromebooks.refresh();
        } else {

            // the user wants to check in a  chromebook
        }
    }

    public void login() {
        // Rohan will work here

        currentUser = GoIn.allGoIns.get(0);
        currentUser.setCheckedOutChromeBook(ChromeBook.allChromeBooks.get(0));

        int currentID = Integer.parseInt(AutoID.getText());

        for ( GoIn eachGoin : GoIn.allGoIns) {
            if (eachGoin.ID == currentID) {
                currentUser = eachGoin;
            }
        }
        studentName.setText(currentUser.getName());
        studentID.setText(String.valueOf(currentUser.getID()));
        Image currentUserImage = currentUser.getFace();
        //if (currentUserImage != null) {
            studentFace.setImage(currentUserImage);
        //}

        if (currentUser.checkedOutChromeBook != null) {
            Chromebooks.getSelectionModel().select(currentUser.checkedOutChromeBook);
        } else {
            CheckInOutButton.setText("Check Out chromebook");
        }
    }

    public void uploadPicture(ActionEvent actionEvent) throws Exception {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(stage);
        FileInputStream input = new FileInputStream(selectedFile);
        Image image = new Image(input);
        studentFace.setImage(image);
        currentUser.setFace(image);
    }
}

