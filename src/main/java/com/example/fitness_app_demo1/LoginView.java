package com.example.fitness_app_demo1;

/*
Edits:
Date        Name        Edits
====        ====        ========================================



Notes:
Date    Comments
====    ===============================================================


 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class LoginView {
    //Use gridpane as the root node
    GridPane root = new GridPane(10,10);
    Controller c;               //Reference to main controller

    //Constructor - accepts a reference to the main controller
    public LoginView(Controller c) {
        this.c = c;
        root.setStyle("-fx-border-color: #252525;" + "-fx-border-radius: 10;" +
                "-fx-background-color: gray;" + "-fx-background-radius: 10;");
        root.setAlignment(Pos.CENTER);
    }

    public void buildLoginView() {
        //----Login fields
        Label username = new Label("Username:");
        Label pass = new Label("Password:");
        //Text fields
        TextField unameField = new TextField();
        unameField.setPromptText("Enter your username");
        unameField.setStyle("-fx-border-radius: 10;" +"-fx-background-radius: 10;" );
        TextField passField = new PasswordField();
        passField.setPromptText("Enter your password");
        passField.setStyle("-fx-border-radius: 10;" +"-fx-background-radius: 10;" );
        //Add labels and fields to root
        root.add(username,0,0);     //Username: []
        root.add(unameField,1,0);
        root.add(pass,0,1);         //Password: []
        root.add(passField,1,1);

        //----Hbox for login/Create account button
        HBox h = new HBox(10);
        h.setPadding(new Insets(20));
        h.setAlignment(Pos.CENTER_RIGHT);               //Position to the bottom-right of the login fields

        Button loginB = new Button("Login");
        loginB.setStyle("-fx-border-radius: 15;" +"-fx-background-radius: 15;" +
                        "-fx-font-weight: 'Segoe UI', 'Arial';");
        Button regB = new Button("Create Account");
        regB.setStyle("-fx-border-radius: 15;" +"-fx-background-radius: 15;" +
                "-fx-font-weight: 'Segoe UI', 'Arial';");

        h.getChildren().addAll(loginB, regB);           //Add buttons to hbox
        root.add(h,0,2);



    }




    //Return root
    public GridPane getRootNode() { return this.root; }

}
