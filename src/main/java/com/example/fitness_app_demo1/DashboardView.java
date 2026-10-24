package com.example.fitness_app_demo1;

/*
Edits:
Date        Name        Edits
====        ====        ========================================
10/21       Mo          Created class
10/24        Mo          Added basic UI additions to show User data/logs


 */

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardView {

    Controller c;

    //Root node
    BorderPane root = new BorderPane();

    //Top bar
    Label usernameTl;
    Button logoutB;

    //Nodes that needs a handler or controller may need reference to
    SplitPane splitPane = new SplitPane();            //Profile | logs

    //LeftBox - profile info
    Label profile;    //Hold profile info

    //RightBox - logs
    ListView<DailyLog> list;            //Listview to view logs



//----------------Constructor-------------------------------------------------
    public DashboardView(Controller c) {
        splitPane.setDividerPositions(0.4);         // 40/60 split
         root.setCenter(splitPane);                 //Set splitpane as center of the borderpane
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
        usernameTl.setFont(Font.font("System", FontWeight.EXTRA_BOLD, 20));
        //Logout button
        logoutB = new Button("Logout");
        logoutB.setStyle("-fx-border-color: #746f6f;" + "-fx-background-radius: 10;" +
                "-fx-background-radius: 10;");          //Rounded corners

        tbar.getChildren().addAll(usernameTl,spacer,logoutB);       //Add elements to top bar
        root.setTop(tbar);          //Set top bar on the top of borderpane
    }

    //Create center splitpane - profile | logs
    public void buildCenterPane() {
        //Vbox in splitpane to hold Profile info - leftbox
        VBox leftBox = new VBox(10);
        leftBox.setPadding(new Insets(10));
        leftBox.setAlignment(Pos.TOP_LEFT);

        Label lprofile = new Label("Account");
        lprofile.setStyle("-fx-font-size: 18;" + "-fx-font-family: 'Segoe UI', 'Arial';" +
                        "-fx-font-weight: normal;");
        profile = new Label();        //User info will be loaded into this label
        profile.setStyle("-fx-font-size: 18;" + "-fx-font-family: 'Segoe UI', 'Arial';" +
                "-fx-font-weight: normal;");

        leftBox.getChildren().addAll(lprofile, profile);       //Add the labels to the leftbox
        VBox.setVgrow(leftBox, Priority.ALWAYS);            //Fill vertically


        //Vbox in splipane to hold logs - rightbar
        VBox rightBox = new VBox(10);
        rightBox.setPadding(new Insets(10));
        rightBox.setAlignment(Pos.TOP_LEFT);

        //Add ListView to hold logs
        Label logTitle = new Label("User Logs...");     //title for rightbox

        list = new ListView<>();        //Instantiate listview
        list.setStyle("-fx-font-size: 12;" + "-fx-font-family: 'Segoe UI', 'Arial';" +
                "-fx-font-weight: normal;");
        rightBox.getChildren().addAll(logTitle, list);      //Add logTitle and listview to right box
        list.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(list, Priority.ALWAYS);       //Fill vertically

        splitPane.getItems().addAll(leftBox, rightBox);       //Add left and right box to splitpane

    }





}
