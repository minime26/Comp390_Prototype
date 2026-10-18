package com.example.fitness_app_demo1;


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
    Button button = new Button();

    public App(Stage stage) {
        this.stage = stage;

        buildLoginScene();
    }

    public void buildLoginScene() {
        Text text = new Text("");
        text.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 20));
        text.setFill(Color.AQUA);
        TextFlow area = new TextFlow();
        area.getChildren().add(text);

        button.setText("Click Me");
        button.setOnAction(e -> {
            if (text.getText().isBlank())
                text.setText("Button Works!\tClick to reset.");
            else
                text.setText("");
        });

        VBox box = new VBox(10, area, button);
        this.loginScene = new Scene(box, 800, 600);
        stage.setScene(loginScene);

    }

    public Scene getScene() {return this.loginScene; };


}
