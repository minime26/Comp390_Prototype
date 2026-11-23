package com.example.fitness_app_demo1;

/*
Edits:
Date        Name        Edits
====        ====        ========================================
11/8       Mo          Created class


 */

import java.util.*;

public class UserMap {

    //HashMap <username, User> -for easy look-ups
    HashMap<String, User> userMap;

    //Only a default constructor that instantiates the map
    public UserMap() {
        userMap = new HashMap<>();
    }

//------------Accessors/Mutators----------------------------------------------
    //==============getters============

    public HashMap<String, User> getUserMap() {     //return the map
        return userMap;
    }

    public List<Map.Entry<String, User>> getEntries() {     //return list of all entries
        return new ArrayList<>(userMap.entrySet());
    }

    public List<String> getUsersnameList() {        //return a list of usernames
        return new ArrayList<>(userMap.keySet());
    }

    public List<User> getUserList() {              //return a list of User objects
        return new ArrayList<>(userMap.values());
    }

    public User getUser(String username) {      //returns user if exists
        if (username == null) return null;
        return userMap.get(username.toLowerCase().trim());      //return null if username not in map
    }

    public int size() { return userMap.size(); }    //return size of map

    //==============mutators============
    public boolean add(String username, User user) {
        if (username == null || user == null) return false;
        return userMap.putIfAbsent(username.toLowerCase().trim(), user) == null;        //returns null if success or User if username is taken
    }       //check isUser(User) when validating since map allows duplicate values


    public User remove(String username) {        //remove user
        if (username == null)
            throw new IllegalArgumentException("Username cannot be null.");
        return userMap.remove(username.toLowerCase().trim());   //return null if not found
    }


    public User remove(User user) {        //remove user or //return null if not found
        if (user == null)
            throw new IllegalArgumentException("User cannot be null.");
        String username = user.getUserName();
        return remove(username);
    }

    public void clear() { userMap.clear(); }    //clear map



    //----Helper Methods---------------------------------------------------
    public boolean isUser(String username) {        //check if username is in map
        if (username == null) return false;                 //check null
        String uname = username.toLowerCase().trim();       //check lowercase(username)
        return userMap.containsKey(uname);
    }

    public boolean isUser(User user) {        //check if user is in map
        if (user == null) return false;                 //check null
        return isUser(user.getUserName());
    }



}
