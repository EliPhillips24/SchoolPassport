package com.example.schoolpassport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class  HelloApplication extends Application {
    @Override
public void start(Stage stage) throws Exception {
    boolean WhatSpell = false;

    FXMLLoader fxmlLoader;
    try {

        if (WhatSpell == true) {
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 270);
            stage.setScene(scene);
        } else {
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AdminView.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 500, 270);
            stage.setScene(scene);
        }
        stage.setTitle("Hello!");
        stage.show();

    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        launch();
    }
}