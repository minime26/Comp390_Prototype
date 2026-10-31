package com.example.fitness_app_demo1;

/*
Description:
    Utility class to create elements for UI

 */

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.time.format.DateTimeFormatter;

public final class Elements {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");        //used for logs in dashboard

    private Elements() {}

    public static TextField createTextField(String prompt) {
        TextField t = new TextField();
        t.setPromptText(prompt);        //Set pre-filled text
        t.setStyle("-fx-border-radius: 10;" +"-fx-background-radius: 10;");
        return t;
    }

    public static TextField createTextField(String prompt, int size) {
        TextField t = new TextField();
        t.setPromptText(prompt);        //Set pre-filled text
        t.setStyle("-fx-border-radius:10;" +"-fx-background-radius: 10;");
        t.setPrefColumnCount(size);     //Set preferred size
        return t;
    }

    public static Button createButton(String prompt) {
        Button b = new Button(prompt);
        b.setStyle("-fx-border-color: #746f6f;" + "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;");          //Rounded corners
        b.setMinWidth(Region.USE_PREF_SIZE);
        return b;
    }


}
