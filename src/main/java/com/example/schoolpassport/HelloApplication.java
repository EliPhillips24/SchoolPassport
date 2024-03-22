package com.example.schoolpassport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class  HelloApplication extends Application {
    static boolean WhatSpell = true;


    public void start(Stage stage) throws Exception {
        //boolean WhatSpell = false;
        FXMLLoader fxmlLoader;

        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public static void Swap() throws Exception {

        WhatSpell = !WhatSpell;
        System.out.println("    123    ");

    }

    public static void main(String[] args) {
        launch();
    }
}