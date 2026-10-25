package com.example.fitness_app_demo1;

/*
Edits:
Date        Name        Edits
====        ====        ========================================
10/25       Mo          Created class


 */

public class UserManager {
    //Attributes
    UserMap userMap = new UserMap();        //New map<String, user>


//Constructor - **Empty for now
    public UserManager() {

    }

//---------Validation Methods------------------------
    public boolean isCurrentUser(String username) throws Exception {    //Checks if username is registered
        if (username == null) return false;
        return userMap.userInMap(username);
    }

    public boolean isPassMatch(String enteredPass, User user) {         //checks password
        if (enteredPass == null || user == null)
            throw new IllegalArgumentException("Password and user cannot be null.");
        if (enteredPass.isBlank())
            throw new IllegalArgumentException("Password cannot be blank.");
        return user.getPassword().equals(enteredPass);
    }

//    public User authenticate(String username, String password) { .....






}
