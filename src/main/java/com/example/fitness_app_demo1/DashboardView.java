package com.example.fitness_app_demo1;

/*
Edits:
Date        Name        Edits
====        ====        ========================================
10/21       Mo          Created class
10/24       Mo          Added basic UI additions to show User data/logs
10/25       Mo          Cosmetic adjustments to UI


 */

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.StringConverter;

import java.time.LocalDate;

public class DashboardView {

    Controller c;

    //Root node
    BorderPane root = new BorderPane();

    //Top bar
    Label usernameTl;
    Button logoutB;

    //Nodes that needs a handler or controller may need reference to
    SplitPane splitPane = new SplitPane();            //Profile | logs
    SplitPane vert = new SplitPane();                   //(Profile | logs) / Visual data

    //LeftBox - profile info
    Label profile;    //Hold profile info

    //RightBox - logs
    ListView<DailyLog> list;            //Listview to view logs
                //add log
    DatePicker datePicker;
    TextField weight;
    TextField steps;
    TextField calIntake;
        //workout (optional)
    ComboBox<DailyLog.Activity> activity;
    TextField dur;
    Button addLog;      //add log button


    //Lower - vert splitpane
    StackPane lowBox;
//    Label temp;                   Used for testing



//----------------Constructor-------------------------------------------------
    public DashboardView(Controller c) {
        splitPane.setDividerPositions(0.4);         // 40/60 split
        vert.setDividerPositions(0.5);
        root.setCenter(vert);                 //Set vertical splitpane as center of the borderpane
        buildTopBar();          //Create top and center panes on UI
        buildCenterPane();


    }

//---------------Getters--------------------------------
    public BorderPane getRootNode() { return this.root; }
    public SplitPane getSplitPane() { return this.splitPane; }
    //top bar
    public Label getUsernameTl() { return this.usernameTl; }
    public Button getLogoutTb() { return this.logoutB; }

    //left bar of splitpane
    public Label getProfileLl() { return this.profile; }

    //Right box of splitpane
    public ListView<DailyLog> getListView() { return this.list;}

    //Lower - ver splitpane
    public StackPane getLowBox() {return lowBox; }


    //Create topbar - Profile: "username"       Logout
    public void buildTopBar() {


        HBox tbar = new HBox(10);
        tbar.setPrefHeight(40);
        tbar.setAlignment(Pos.CENTER_LEFT);
        tbar.setStyle("-fx-border-color: #433c3c;" + "-fx-border-width: 0 0 2 0;");     //Separate bottom border

        Region spacer = new Region();                       //Spacer to keep logout on the opposite end
        HBox.setHgrow(spacer, Priority.ALWAYS);             //Consume leftover space in the middle
        //Set label = username
        usernameTl = new Label();                           //Profile: "username"
        usernameTl.setFont(Font.font("System",FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20));
        //Logout button
        logoutB = new Button("Logout");
        logoutB.setStyle("-fx-border-color: #746f6f;" + "-fx-background-radius: 10;" +
                "-fx-border-radius: 10;");          //Rounded corners

        tbar.getChildren().addAll(usernameTl,spacer,logoutB);       //Add elements to top bar
        root.setTop(tbar);          //Set top bar on the top of borderpane
    }

    //Create center splitpane - profile | logs
    public void buildCenterPane() {
        //Vbox in splitpane to hold Profile info - leftbox
        VBox leftBox = new VBox(10);
        leftBox.setPadding(new Insets(0,0,5,0));
        leftBox.setAlignment(Pos.TOP_LEFT);

        //Account header
        Label lprofile = new Label("Account");
        lprofile.setStyle("-fx-font-size: 16;" + "-fx-font-family: 'Segoe UI', 'Arial';" + "-fx-underline: false;" +
                        "-fx-font-weight: bold;" + "-fx-border-color: #cfc4c4;" + "-fx-background-color: transparent;" +
                        "-fx-border-radius: 15;" + "-fx-background-radius: 15;" + "-fx-padding: 5;");

        HBox leftSplitTop = new HBox(10);
        leftSplitTop.setMaxWidth(Double.MAX_VALUE);
        leftSplitTop.setStyle("-fx-padding: 0 0 5 0;" + "-fx-background-color: #c3b7b7;" + "-fx-alignment: center");
        leftSplitTop.getChildren().add(lprofile);           //Add account label to hbox

        profile = new Label();        //User info will be loaded into this label
        profile.setStyle("-fx-font-size: 18;" + "-fx-font-family: 'Segoe UI', 'Arial';" +
                "-fx-font-weight: normal;");
        profile.setAlignment(Pos.CENTER);

        leftBox.getChildren().addAll(leftSplitTop, profile);       //Add the hbox and profile to the leftbox

        //Vbox in splipane to hold logs - rightbar
        VBox rightBox = new VBox(10);
        rightBox.setPadding(new Insets(0,0, 5, 0));
        rightBox.setAlignment(Pos.TOP_LEFT);


        Label logTitle = new Label("User Logs...");     //title for rightbox
        logTitle.setStyle("-fx-font-size: 16;" + "-fx-font-family: 'Segoe UI', 'Arial';" + "-fx-underline: false;" +
                "-fx-font-weight: bold;" + "-fx-border-color: #cfc4c4;" + "-fx-background-color: transparent;" +
                "-fx-border-radius: 15;" + "-fx-background-radius: 15;" + "-fx-padding: 5;");
        HBox rightSplitTop = new HBox();
        leftSplitTop.setMaxWidth(Double.MAX_VALUE);
        rightSplitTop.setStyle("-fx-padding: 0 0 1 0;" + "-fx-background-color: #c3b7b7;" + "-fx-alignment: center");
        rightSplitTop.getChildren().add(logTitle);           //Add log title to hbox

        //Add log option----------
        HBox addLogView = new HBox(5);
        //create date picker
        datePicker = new DatePicker();
        datePicker.setEditable(false);                  //Prevent user from editing the text field of the date picker

        datePicker.setConverter(new StringConverter<LocalDate>() {      //convert date to for dd/MM/yy
            @Override
            public String toString(LocalDate date) {
                if (date != null)
                    return Elements.formatter.format(date);
                return  "";
            }
            @Override
            public LocalDate fromString(String string) {            //Can be ignored since textbox will be disabled
                return null;
            }
        });
        datePicker.setValue(LocalDate.now());           //show today's date by default
        datePicker.getEditor().setPrefColumnCount(8);
        //create textfields to get log info
        weight = Elements.createTextField("lbs", 5);
        steps = Elements.createTextField("Steps", 6);
        calIntake = Elements.createTextField("Calories", 6);
        activity = new ComboBox<>();        //drop down for workouts
        activity.setPromptText("Activity");
        activity.getItems().addAll(DailyLog.Activity.values()); //Load workout options
        dur = Elements.createTextField("mins", 5);

        Region spacer = new Region();               //create spacer to separate add log button
        HBox.setHgrow(spacer, Priority.ALWAYS);

        addLog = Elements.createButton("Add Log");  //create add log button
        addLog.setStyle("-fx-padding: 3 5 3 5");
        //add all to HBox
        addLogView.getChildren().addAll(datePicker, weight, steps, calIntake, activity,
                                                dur, spacer, addLog);       //---------------

        //Add ListView to hold logs--------------
        list = new ListView<>();        //Instantiate listview
        list.setStyle("-fx-font-size: 14;" + "-fx-font-family: 'Segoe UI', 'Arial';" +
                "-fx-font-weight: normal;");

        rightBox.getChildren().addAll(rightSplitTop, addLogView, list);      //Add logTitle, addlogView, and listview to right box
        list.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(list, Priority.ALWAYS);       //Fill vertically

        splitPane.getItems().addAll(leftBox, rightBox);       //Add left and right box to splitpane
        splitPane.setStyle("-fx-background-color: #f1eeee;");

        //Vertical split pane to placer user|log / visual data----------------
        vert.setOrientation(Orientation.VERTICAL);      //Set orientation - verticle

        //Hbox in the lower part of the vertical splitpane
        lowBox = new StackPane();
        vert.getItems().addAll(splitPane, lowBox);  //Add top splitpane and bottom pane to stackpane

        //*****************************Temp Nodes***************************************************
/*
        temp = new Label("Visual Data Here......");      //***************TEMP LABEL
        temp.setStyle("-fx-font-size: 80;" + "-fx-font-family: 'Segoe UI', 'Arial';" +
                        "-fx-font-weight: 800;" + "-fx-text-fill: blue;");

        lowBox.getChildren().add(temp);         //Add tempt label


*/
        //*****************************Temp Nodes***************************************************


    }





}
