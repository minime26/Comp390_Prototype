package com.example.fitness_app_demo1;

/*
Edits:
Date        Name        Edits
====        ====        ========================================
10/31       Mo          Created class
11/1        Mo          Added the rows of the form and submit/clear button
            Mo          created wrapper for the gridpane to center in scrollpane



 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    //Root pane - Gridpane
    private ScrollPane root = new ScrollPane();
    private StackPane center = new StackPane();     //wrapper pane
    private GridPane grid = new GridPane(10, 10);

    //record to save each row
    public record FormRow(Label label, TextField field, Label erLabel) {}

    //list to hold records of each row
    private final List<FormRow> formRows = new ArrayList<>();

    //top row with title of page
    HBox tbar;
    Label title;

    //submit button on bottom row
    HBox bottomRow = new HBox(10);
    Button submit;
    Button clear;


    //constructor
    public Registration() {

        grid.setStyle("-fx-border-color: #252525;" + "-fx-border-radius: 10;" +
                "-fx-background-color: #f1eeee;" + "-fx-background-radius: 10;");

         //wrap grid in a stackpane to center
         center = new StackPane(grid);
        center.minWidthProperty().bind(root.widthProperty());   //bind grids width/height to root
        center.minHeightProperty().bind(root.heightProperty());
        root.setContent(center);        //add the wrapper to root
        grid.setPadding(new Insets(20,5,5,20));

        loadForm();     //load form to UI
    }

    //Getters-------------------------

    public ScrollPane getRootNode() {return this.root; }    //return root

    public Button getSubmitButton(){
        return submit;


    }


    public Button getClearButton () {
        return clear;

    }

    public List<FormRow> getFormRows() {
        return List.copyOf(formRows);
    }






    //------------------------------------

    //Create top row
    public void buildTopRow(int row) {
        tbar = new HBox(10);
        tbar.setStyle("-fx-padding: 0 0 0 0;" + "-fx-background-color: #c3b7b7;" +
                            "-fx-alignment: center");

        tbar.setAlignment(Pos.CENTER);
        tbar.setMaxWidth(Double.MAX_VALUE);


        title = new Label("Create Account");
        title.setStyle("-fx-font-size: 16;" + "-fx-font-family: 'Segoe UI', 'Arial';" + "-fx-underline: false;" +
                "-fx-font-weight: bold;" + "-fx-border-color: transparent;" + "-fx-background-color: transparent;" +
                "-fx-border-radius: 15;" + "-fx-background-radius: 15;" + "-fx-padding: 5;" +
                    "-fx-alignment: center;");

        tbar.getChildren().add(title);      //add title to top bar
        grid.add(tbar, 0, row);       //add top bar to grid
        GridPane.setHgrow(tbar, Priority.ALWAYS);
        GridPane.setColumnSpan(tbar, 3);        //span across all columns

    }
public void createField (int row, String label, String fieldPrompt) {
    createField(row, label, fieldPrompt, false);
}
    
    public void createField(int row, String label, String fieldPrompt, boolean password) {
        List<Control> controls = Elements.createRegLabel(label, fieldPrompt, password);

        FormRow currentRow = new FormRow((Label) controls.get (0), (TextField) controls.get (1), (Label) controls.get (2));

        formRows.add(currentRow);

        for (int i = 0; i < controls.size(); i++) {
            grid.add(controls.get(i), i, row);
        }
    }

    public void loadForm() {
        int row = 0;

        buildTopRow(row);       //build top bar

        createField(++row, "Username:", "Enter your username");
        createField(++row, "Password:", "Enter your password",true);
        createField(++row, "Confirm Password:", "Re-enter your password",true);
        createField(++row, "First Name:", "Enter your first name");
        createField(++row, "Last Name:", "Enter your last name");
        createField(++row, "Age:", "Enter your age:");
        createField(++row, "Gender:", "Select your gender");
        createField(++row, "Height (inches):", "Enter your height");
        createField(++row, "Weight (lbs):", "Enter your weight");

        //optional
        createField(++row, "Weight Goal (lbs,optional):", "Enter your target weight");

        buildBottomBar(row+1);

    }




    //bottom row with submit button
    public void buildBottomBar(int row) {
        submit = new Button("Submit");      //Create submit button
        submit.setStyle("-fx-border-radius: 15;" +"-fx-background-radius: 15;" + "-fx-font-size: 14;" +
                "-fx-font-family: 'Segoe UI', 'Arial';" + "-fx-font-weight: 600;" + "-fx-padding: 6 12");
        clear = new Button("Clear");        //clear button
        clear.setStyle("-fx-border-radius: 15;" +"-fx-background-radius: 15;" + "-fx-font-size: 14;" +
                "-fx-font-family: 'Segoe UI', 'Arial';" + "-fx-font-weight: 600;" + "-fx-padding: 6 12");

        bottomRow.getChildren().addAll(clear, submit);      //add both buttons to hbox
        bottomRow.setAlignment(Pos.CENTER_RIGHT);        //center-left in the third column
        grid.add(bottomRow, 1, row);            //place hbox in column 1 with buttons
        GridPane.setColumnSpan(bottomRow, 2);       //Span hbox col 1 & 2
    }

    //create row using label prompt and field prompt
    // public void createField(int row, String label, String fieldPrompt) {
    //     //get elements for the row
    //     List<Control> controls = Elements.createRegLabel(label, fieldPrompt);   //create labels and text field
    //     FormRow currentRow = new FormRow(
    //             (Label) controls.get(0), (TextField) controls.get(1), (Label) controls.get(2));

    //     formRows.add(currentRow);       //add row to list

    //     for (int i=0; i < 3 ; i++) {        //add elements to the given row [label: TextField (error)]
    //         grid.add(controls.get(i),i, row);
 //
}     
