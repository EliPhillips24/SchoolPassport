package com.example.schoolpassport;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminView {
    private Stage stage;
    private Scene scene;
    private Parent root;
    protected void adminRemove() throws IOException {}
    protected void adminData() throws IOException {}
    protected void initialize() throws IOException {}
    public void normalMode(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
