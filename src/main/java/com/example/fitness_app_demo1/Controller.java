package com.example.fitness_app_demo1;
/*
Edits:
Date        Name        Edits
====        ====        ========================================
10/19       Mo          Created class, constructor takes main stage and sets scene to the the login view


 */


import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Controller {

    //Attributes
    Stage stage;                    //Main stage
    Scene scene;                    //Scene to add to
    User user;                      //Current user;



    //Constructor - accepts the main stage and creates a loginScene
    public Controller (Stage stage) {

        LoginView newLoginView = new LoginView(this);           //Create a new Login view on start
        Scene scene = new Scene(newLoginView.getRootNode());        //Add root node to Scene
        stage.setScene(scene);                                      //Sets scene to stage

    }

//-----------Switch views---------------------------
    public void switchToDashboard() {               //Switches to user Dashboard view
        DashboardView userDB = new DashboardView(this);
        scene.setRoot(userDB.getRootNode());
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
