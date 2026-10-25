package com.example.fitness_app_demo1;

/*
Edits:
Date        Name        Edits
====        ====        ========================================
10/19       Mo          Created class, constructor takes main stage and sets scene to the the login view
10/24       Mo          Adjusted switchTo methods to return an object of the view
                        Added instance fields to set up triggers for login/DB
10/25       Mo          Added listers/triggers for logout and to retain focus on root pane when user clicks away.


 */


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Controller {

    //Reference to different screens
    LoginView loginView;
    DashboardView dbView;

    //Attributes to determine active view/user
    Stage stage;                    //Main stage
    Scene scene;                    //Scene to add to
    User user;                      //Current user;

    //Fields - Dashboard
    ObservableList<DailyLog> obLogs = FXCollections.observableArrayList();


    //Constructor - accepts the main stage and creates a loginScene
    public Controller (Stage stage) {

        loginView = new LoginView(this);           //Create a new Login view on start
        scene = new Scene(loginView.getRootNode(),1000,800);        //Add root node to Scene
        stage.setScene(scene);                                      //Sets scene to stage
        loginListeners(loginView);                   //Attach listeners/triggers
        Platform.runLater(() -> loginView.getRootNode().requestFocus());    //Retain focus on root pane
    }

//-----------Login view listeners---------------------------
//-----Login Nodes-----------------------------------------------------------
/*      Label username: TextField unameField
        Label pass    :  TextField passField
                             Button "login"   Button "Create Account"
*/
    public void loginListeners(LoginView view) {
        //On reg-click -> Registration page
        /*
        view.regB.setOnAction(e -> {
            //Switch to a new registration page
        } );
        */

        //On login-click -> validate username/password and view DB
        view.loginB.setOnAction(e -> {
                String username = view.unameField.getText();        //Get username and password
                //String pass = view.passField.getText();
                view.clearFields();                                 //Clear previously entered fields
                //Call methods in UserManager to verify username
                //this.user = verified user
                //If/oncer username verified, switch dashboard and load user info

                user = preload(username);           //===Preload user for **testing**
                //Login to user dashboard
                switchToDashboard();          //Switch to DB view and load user info

        });

        view.getRootNode().setOnMouseClicked( e -> {
            loginView.getRootNode().requestFocus();
        });


    }

    //------Dashboard Listeners--------------------
    public void dbListeners() {
        //Configure logout button
        dbView.getLogoutTb().setOnAction(e -> {
            logOut();           //Reset DB and user reference, switch to login view
        });

        dbView.getRootNode().setOnMouseClicked( e -> {
            dbView.getRootNode().requestFocus();
        });
    }



//-----------Switch views---------------------------
    public void switchToDashboard() {               //Switches to user Dashboard view
        dbView = new DashboardView(this);
        dbView.getListView().setItems(obLogs);              //Connect obLogs to list view
        updateLogs();                                     //Load Obserablelist with user logs
        dbView.getProfileLl().setText(user.toString());     //Load left box with user data
        dbView.getUsernameTl().setText(user.getUserName());  //Display username in top left
        scene.setRoot(dbView.getRootNode());                //set Scene to dashboard view
        dbListeners();                                      //Set up listeners/triggers
        Platform.runLater(() -> dbView.getRootNode().requestFocus());    //Retain focus on root pane
    }

    public void switchToLogin() {                   //Switches to user login screen
        loginView = new LoginView(this);
        scene.setRoot(loginView.getRootNode());
        loginListeners(loginView);                   //Attach listeners/triggers
        Platform.runLater(() -> loginView.getRootNode().requestFocus());    //Retain focus on root pane
    }













//-----------Helper Methods----------------------------------------------------

    //Dashboard
    public void setUIlogs() {       //Updates ObserveableList with current user logs
        obLogs.setAll(user.getLogs());                  //Arraylist -> ObservableArrayList
    }

    public void updateLogs() {
        if (user == null) {        //Check if user is null, clear logs
            obLogs.clear();
            return;
        }
        ListView<DailyLog> view = dbView.getListView();

        setUIlogs();            //Update Observable list

        int last = obLogs.size() - 1;       //Show latest logs
        if (last >= 0)
            Platform.runLater(() -> view.scrollTo(last));       //Run after UI loads
    }

    public void logOut() {
        user = null;                    //Set user to null
        switchToLogin();
        updateLogs();                   //Clear obLogs
        dbView = null;                  //Reset DB
    }







//---------------------------------Methods for testing only----------------------------------------------------------------

    //Preload data
    public User preload(String username){
        int p = Character.getNumericValue(username.charAt(username.length()-1));        //get the correct profile
        LocalDate date = LocalDate.of(2026,10,1);
        LocalDate date1 = date.plusDays(1);
        LocalDate date2 = date.plusDays(2);
        LocalDate date3 = date.plusDays(3);

        if (p == 1) {
            //Create user
            User p1 = new User(username, date, "John",
                    "Smith", 25, "Female", 68, 150, 130);

            //Create logs and add to user's profile
            DailyLog log1 = new DailyLog(p1, date1, 150, 5500, 2000,
                    DailyLog.Activity.CYCLING, 25);
            DailyLog log2 = new DailyLog(p1, date2, 150, 6000, 1900,
                    DailyLog.Activity.CYCLING, 25);
            DailyLog log3 = new DailyLog(p1, date3, 148, 6500, 1800,
                    DailyLog.Activity.CYCLING, 25);
            p1.addLog(log1); p1.addLog(log2); p1.addLog(log3);      //Add logs
            return p1;
        }
        else
        {
            //Create user
            User p2 = new User(username, date, "Jane",
                    "Smith", 25, "Female", 62, 120, 110);

            //Create logs and add to user's profile
            DailyLog log1 = new DailyLog(p2, date1, 120, 5500, 2000,
                    DailyLog.Activity.CYCLING, 25);
            DailyLog log2 = new DailyLog(p2, date2, 120, 6000, 1900,
                    DailyLog.Activity.CYCLING, 25);
            DailyLog log3 = new DailyLog(p2, date3, 119, 6500, 1800,
                    DailyLog.Activity.CYCLING, 25);
            p2.addLog(log1); p2.addLog(log2); p2.addLog(log3);      //Add logs
            return p2;
        }
    }






}
