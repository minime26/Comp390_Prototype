package com.example.fitness_app_demo1;

/*
Edits:
Date        Name        Edits
====        ====        ========================================
10/25       Mo          Created class
10/26       Mo          Added accessors and mutators

 */

import java.time.LocalDate;
import java.util.ArrayList;

public class UserManager {
    //Attributes
    UserMap userMap = new UserMap();        //New map<String, user>


//Constructor - **Empty for now
    public UserManager() {

    }

//---------Validation Methods------------------------
    public boolean isCurrentUser(String username) throws Exception {    //Checks if username is registered
        if (username == null)
            throw new IllegalArgumentException("Username cannot be null.");
        username = username.trim().toLowerCase();                   //normalize username
        if(!userMap.userInMap(username))
            return false;
        return true;
    }

    public boolean isCurrentUser(User user) {   //Check if user is registered
        if (user == null)
            throw new IllegalArgumentException("User cannot be null.");
        return userMap.getAllUsers.contains(user);
    }

    public boolean isPassMatch(String enteredPass, User user) {         //checks password
        if (enteredPass == null || user == null)
            throw new IllegalArgumentException("Password and user cannot be null.");
        if (enteredPass.isBlank())
            throw new IllegalArgumentException("Password cannot be blank.");
        return user.getPassword().equals(enteredPass);
    }

    public User authenticate(String username, String password) throws Exception {
        User user = getUser(username);      //Get user with the specified username
        if(!isPassMatch(username, user))    //Check if password matches
            throw new IllegalArgumentException("Username or password does not match.");
        return user;
    }


//---------Access methods------------------------
    public User getUser(String username) throws Exception { //get user if username matches one
        if (username == null)
            throw new IllegalArgumentException("Username cannot be null.");
        if(!isCurrentUser(username))
            throw new IllegalArgumentException("Username does not exist.")
        return userMap.getUser(username);       //Return user
    }

    public ArrayList<User> getAllUsers() {     //get all users
        ArrayList<User> users = userMap.getAllUsers();
        if (users.isEmpty())
            throw new IllegalArgumentException("There are no registered users.");   //Chcek for empty list
        return userMap.getAllUsers();       //Return a list containing all registered users
    }

    public ArrayList<DailyLog> getLogs(User user, LocalDate date) { //get logs from the date
        if (user == null || date == null)       //Check null
            throw new IllegalArgumentException("User and date cannot be null.");
        ArrayList<DailyLog> logs = (ArrayList<DailyLog>) user.getLogs(date);
        if (logs.isEmpty())     //Check if any saved logs for the date
            throw new IllegalArgumentException("No logs for the specified date.");
        return logs;
    }

    public ArrayList<DailyLog> getLogs(User user) { //get all logs for the user
        if (user == null)
            throw new IllegalArgumentException("User cannot be null.");
        ArrayList<DailyLog> logs = (ArrayList<DailyLog>) user.getLogs();
        if (logs.isEmpty())     //Check if any saved logs for the date
            throw new IllegalArgumentException("No logs saved on the account.");
        return logs;
    }

//---------------Mutators----------------------------------

    public boolean addUser(User user) {
        if(isCurrentUser(user))
            throw new IllegalArgumentException("User already exists.");
        userMap.add(user);
        return true;
    }

    public boolean addLog(User user, DailyLog log) {
        if (log == null)
            throw new IllegalArgumentException("User and log cannot be null.");
        if(!isCurrentUser(user))
           throw new IllegalArgumentException("This is not a registered user.");

        user.addLog(log);
        return true;
    }

    public boolean addLog(String user, DailyLog log) {

    }

}
