package com.example.fitness_app_demo1;

/*
Description:
    Utility class to create elements for UI

 */

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Elements {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");        //used for logs in dashboard
    public static final String errorStyle = "-fx-border-color: red; -fx-border-width: 2px;";

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

    //Create error alert
    public static void createErrorAlert(String err) {
        if (err == null || err.isEmpty())
            return;
        Alert alert = new Alert(Alert.AlertType.ERROR);     //create new err alert
        alert.setTitle("Error");
        alert.setContentText(err);

        alert.showAndWait();
    }

    //Create error alert with multiple errors
    public void createErrorAlert(List<String> errs) {
        if (errs == null || errs.isEmpty())
            return;
        Alert alert = new Alert(Alert.AlertType.ERROR);     //create new err alert
        alert.setTitle("Error");
        alert.setHeaderText("Please review the following error(s) and try again.");
        StringBuilder ers = new StringBuilder();
        for (String error : errs) {         //Show all errors line by line

            ers.append("* ").append(error).append("\n");
        }
        //load alert with all errors
        alert.setContentText(ers.toString().trim());
        //show and wait
        alert.showAndWait();
    }

    //apply error to a textfield
    public static void applyErStyle(Control control) {
        if (control == null) return;
        String style = control.getStyle();
        //Check if error style already applied
        if (style != null && style.contains(errorStyle))
            return;

        if (style == null || style.trim().isBlank())   //check if empty
            control.setStyle(errorStyle);
        else
            control.setStyle(style + " " + errorStyle); //apply style
    }

    // Overload to accept a List of controls
    public static void applyErStyle(List<Control> controls) {
        if (controls == null) return;
        for (Control control : controls) {
            applyErStyle(control);
        }
    }

    //Clear error style
    public static void clearErStyle(Control control) {
        if (control == null) return;
        String style = control.getStyle();

        if (style == null || !(style.contains(errorStyle)))
            return;

        String newStyle = style.replace(errorStyle, "").trim();
        control.setStyle(newStyle.isBlank() ? null : newStyle);
    }

    // Overload to accept a List of controls
    public static void clearErStyle(List<Control> controls) {
        if (controls == null) return;
        for (Control control : controls) {
            clearErStyle(control);
        }
    }

//Utilites for registration page---------------------------------
    public static List<Control> createRegLabel(String label, String tf) {
        Label l = new Label(label);                 //Create label
        l.setMaxWidth(Double.MAX_VALUE);
        l.setStyle("-fx-alignment: center-right");

        TextField t = new TextField();              //textfield for input
        t.setPromptText(tf);
        t.setStyle("-fx-border-radius: 10;" +"-fx-background-radius: 10;" +
                                "-fx-pref-column-count: 30;");

        Label errLabel = new Label(" ");        //Potential error field
        errLabel.setStyle("-fx-text-fill: red");

        return new ArrayList<Control>(Arrays.asList(l, t, errLabel));   //return as list
    }



}
