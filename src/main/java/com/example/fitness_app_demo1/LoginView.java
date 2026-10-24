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
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class LoginView {
    //Use gridpane as the root node
    GridPane root = new GridPane(10,10);
    Controller c;               //Reference to main controller

    //Elements to track in controller
    TextField unameField;
    TextField passField;

    Button loginB;
    Button regB;

    //Constructor - accepts a reference to the main controller
    public LoginView(Controller c) {
        this.c = c;
        root.setStyle("-fx-border-color: #252525;" + "-fx-border-radius: 10;" +
                "-fx-background-color: #f1eeee;" + "-fx-background-radius: 10;");
        root.setAlignment(Pos.CENTER);
        buildLoginView();

    }

    public void buildLoginView() {
        //----Login fields
        Label username = new Label("Username:");
        username.setStyle("-fx-alignment: center-right;");  //Alight both labels to match the ":"
        Label pass = new Label("Password:");
        pass.setStyle("-fx-alignment: center-right;");
        //Text fields - width = 30
        unameField = new TextField();
        unameField.setPromptText("Enter your username");
        unameField.setStyle("-fx-border-radius: 10;" +"-fx-background-radius: 10;" + "-fx-pref-column-count: 30;");
        passField = new PasswordField();
        passField.setPromptText("Enter your password");
        passField.setStyle("-fx-border-radius: 10;" +"-fx-background-radius: 10;"+ "-fx-pref-column-count: 30;");

        //Add labels and fields to root
        root.add(username,0,0);     //Username: []
        root.add(unameField,1,0);
        root.add(pass,0,1);         //Password: []
        root.add(passField,1,1);

        //----Hbox for login/Create account button
        HBox h = new HBox(10);
        h.setPadding(new Insets(20));
        h.setAlignment(Pos.CENTER_RIGHT);               //Position to the bottom-right of the login fields

        loginB = new Button("Login");
        loginB.setStyle("-fx-border-radius: 15;" +"-fx-background-radius: 15;" + "-fx-font: 14;" +
                "-fx-font-family: 'Segoe UI', 'Arial';" + "-fx-font-weight: 600;" + "-fx-padding: 6 12");
        regB = new Button("Create Account");
        regB.setStyle("-fx-border-radius: 15;" +"-fx-background-radius: 15;" + "-fx-font: 14;" +
                "-fx-font-family: 'Segoe UI', 'Arial';" + "-fx-font-weight: 600;" + "-fx-padding: 6 12");

        h.getChildren().addAll(loginB, regB);           //Add buttons to hbox
        root.add(h,1,2);

    }

//Clear fields-------------------------------------------------------
    public void clearFields() {
        this.unameField.clear();
        this.passField.clear();
    }

//Getters-------------------------------------------------------
    public GridPane getRootNode() { return this.root; }
    public Controller getController() { return this.c; }

    public TextField getUserField() { return this.unameField; }
    public TextField getPassField() { return this.passField; }

    public Button getLoginButton(){ return this.loginB; }
    public  Button getRegButton() { return this.regB; }




//--------------------------------Helper Methods----------------------------------------------



}
