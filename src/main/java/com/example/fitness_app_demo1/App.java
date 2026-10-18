package com.example.fitness_app_demo1;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class App {

    Stage stage;        //Points to the primary stage

    Scene loginScene;
    Scene profile;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);


    public App(Stage stage) {
        this.stage = stage;

        buildLoginScene();
    }

//----------------Login Scene-------------------------------------------------------------------
    public void buildLoginScene() {
        //Create a box for the main pane, Hbox to show login options
        VBox vbox = new VBox(20);
        HBox hbox = new HBox(30);
        //Title of the login page
        Label titl = new Label("Select your Profile: ");
        titl.setAlignment(Pos.CENTER);
        titl.setMaxWidth(Double.MAX_VALUE);         //Stretch horizontally
        titl.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 35));
        titl.setTextFill(Color.BLACK);

        //Profile 1 button
        Button buttonp1 = new Button("Profile_1");
        buttonp1.setAlignment(Pos.CENTER);
        buttonp1.setPrefSize(300,100);
        buttonp1.setStyle("-fx-background-color: blue;" + "-fx-text-fill: white;" + "-fx-font-size: 24px;" +
                            "-fx-font-weight: 800;" + "-fx-padding: 15 25 15 25;" + "-fx-background-radius: 15px");

        buttonp1.setOnAction(e -> {
            alert.setTitle("Profile Selected");
            alert.setContentText("You picked Profile 1.");
            alert.setHeaderText(null);

            alert.showAndWait();
        });

        //Profile 2 button
        Button buttonp2 = new Button("Profile_2");
        buttonp2.setAlignment(Pos.CENTER);
        buttonp2.setPrefSize(300,100);
        buttonp2.setStyle("-fx-background-color: navy;" + "-fx-text-fill: white;" + "-fx-font-size: 24px;" +
                "-fx-font-weight: 800;" + "-fx-padding: 15 25 15 25;" + "-fx-background-radius: 15px");

        buttonp2.setOnAction(e -> {
            alert.setTitle("Profile Selected");
            alert.setContentText("You picked Profile 2.");
            alert.setHeaderText(null);

            alert.showAndWait();
        });

        hbox.getChildren().addAll(buttonp1,buttonp2);       //Add the profile buttons
    HBox.setHgrow(buttonp1, Priority.ALWAYS);               //Expand them to fill width of the screen
        HBox.setHgrow(buttonp2, Priority.ALWAYS);
        buttonp1.setMaxWidth(Double.MAX_VALUE);
        buttonp2.setMaxWidth(Double.MAX_VALUE);

        vbox.getChildren().addAll(titl,hbox);               //Add title, and hbox to vbox


        this.loginScene = new Scene(vbox, 800, 600);        //Add vbox to login scene
        stage.setScene(loginScene);                                      //Add scene to stage

    }



//----------------Login Scene-------------------------------------------------------------------
















//--------------------------------Helper Methods----------------------------------------------
    public Scene getScene() {return this.loginScene; };


}