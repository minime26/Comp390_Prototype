package com.example.fitness_app_demo1;

/*
Changes:
Date        Name        Edits
====        =====       ==============================================
10/8        Mo          Created a simple demo to confirm javafx libraries are functional.
10/17       Mo          Adjusted to work with fitness app demo.
10/19       Mo          Adjusted to instantiate the main controller and pass the main stage


*/




import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;

import java.io.IOException;


public class Main extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Fitness Tracker");

        Controller mainController = new Controller(stage);       //Create new app object, passing in the stage

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
