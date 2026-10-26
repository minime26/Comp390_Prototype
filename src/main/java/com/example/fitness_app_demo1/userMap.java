/*

Edits:

Date        Name        Edits
====        ====        =====
10/15       James       Created userMap class, added fields, get/set methods
10/20       James       Modified constructor to take User obj as parameter, removed unnecessary
                        /redundant variables/methods
10/21       James       Added methods getUser(), getuserName(), addUserName(), updateUserdata()
10/26       James       Modified constructors, added exception management for getter/setter methods,
                        started ...

*/

package com.example.sprint_1;
import java.util.*;

// need to create, hold map + methods to access, add, delete
public class UserMap {      // *** only going to create ONE instance, use across entire app
// ----------------- fields --------------------------------
    
    private Map<String,User> usersList;   // map holds data for all users

    // test/placeholder profile
    User testUser = new User("user203", "john", "smith", 27, 
                        "male", 86.5, 165.0, 145.0);

// --------------------constructor---------------------------

    public UserMap()   // think of when this constructor is called (what condiitons), what 
                       // should it do? 
    {
        // overloaded constructor, creates empty usersList (map)
        // ***change this part:
        Map<String,User> usersList = new HashMap<String, User>();
    }

    public UserMap(String userName, User user)
    {
        // needs to CREATE user map
        // take in user obj
        userName = userName.trim().toLowerCase();   // dont think this applies to every other
                                                    // time username used in this class

        Map<String,User> usersList = new HashMap<String, User>();

        // setter methods called here

        addUser(userName, user);
       
    }

//----------------------- setters-----------------------------
    public void addUserName(String userName)    
    {
        // adds mapping for username w/ blank/none user val (like a blank/empty profile)
        userName = userName.trim().toLowerCase(); 

        try{
            usersList.put(userName, null);
        } catch (Exception e) {System.out.println("That username is already taken");}
        
    }

    public void addUser(String userName, User user)
    {      
        // adds user paired to map <str username, user user>
        // possible to add user (val) w/o accompanying username (key) but cant see a reason to
        // ie)  usersList.put(null, user);
        userName = userName.trim().toLowerCase(); 
        
        try{
            usersList.put(userName, user);
        } catch (Exception e) {System.out.println("That username is already taken");}

    }

    // updateUserdata() --> finds blank username,user pairing and uses replace(k,v)
    // to add user data to that username
    public void updateUserdata(User user)
    {
        String userName = user.getUserName();
        userName = userName.trim().toLowerCase(); 

        User oldUser = getUserData(userName);

        usersList.replace(userName, oldUser, user);
    }

// -----------------------getters------------------------------
    public String getUserName(User user){   // ****needs to be changed
        // use overloaded method to get username from user obj, OR use Un to return user obj
        String userName = user.getUserName();   // inherited/overloaded from User class
        userName = userName.trim().toLowerCase(); 

        return userName;
    }
    public User getUserData(String userName){
        // return user data (as user obj / value) based on username arg/key

        userName = userName.trim().toLowerCase(); 

        User userProfile = usersList.get(userName);

        /// changed to return exception
        if(userProfile == null) {throw new Exception("No user associated with that username");}

        return userProfile;
        
    }
    // get list of ALL user profiles (testing purpose only)
    public List<String> getListOfUsers(Map<String,User> usersList){ 
        // return list of usernames in userslist
        ArrayList<String> userName_list;
        

        if (usersList.keySet() == null)
        {
            throw new Exception("There are no registered users");
        }
        else    // might not need this 'else' block
        {
            for (String userName : usersList.keySet())
            {
                // theres an easier way to do this, look into later
                userName_list.add(userName);
            }

            return userName_list;
        }
    }
    public Map<String,User> getUsersMap()
    {
        // exception if userslist empty/null value?
        if (usersList == null)
        {
            throw new Exception("There are no users registered at this point");
        }
        return this.usersList;
    }
// ------------------------ "if username/user exists" methods ---------------------------
    public boolean nameInMap(String userName)
    {
        // if username key in map, return true - else return false
        userName = userName.trim().toLowerCase(); 

        if (usersList.containsKey(userName))
        {
            return true;
        }
        else {return false;}
    }
    public boolean userInMap(User user)
    {
        // if user paired with username in map, return true - else return false
        if (usersList.containsValue(user))
        {
            return true;
        }
        else {return false;}
    }
// ------------------------------- misc methods ------------------------------------------
    public void removeUser(String userName)
    {
        // if username mapped to user obj (is in map), remove entry <str, user> from map
        // exception thrown when no user is mapped to given username
        userName = userName.trim().toLowerCase(); 

        if (nameInMap(userName))
        {
            usersList.remove(userName);
        }
        else {throw new Exception("No user associated with that username");}
    }
}
