//validation for registration
import java.util.*;

public class Validation{

    public static void checkPassword(String password){
        if(password == null || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[.*@#$%^&+=])[a-zA-Z0-9.*@#$%^&+=]{8,20}$")){
            throw new IllegalArgumentException(" Password must include at least one digit,  a lower case letter,  an uppercase letter; a special character, at least 8 - 19 characters ");
        }
    }

    public static void checkGender(String gender){
        if(gender == null || !List.of("male", "female", "prefer not to answer").contains(gender.toLowerCase().trim())){
            throw new IllegalArgumentException("Invalid gender option.");
        }
    }

    public static void checkName(String name){
        if(name == null || !name.matches("[a-zA-Z -]+")){
            throw new IllegalArgumentException("Name must only consist of letters");
        }
    }

    public static void checkAge(int age){
        if(age < 12){
            throw new IllegalArgumentException("Must be 12 years old or older to access this app");
        }
    }

    public static void checkHeight(double height){
        if(height < 36){
            throw new IllegalArgumentException("Must be a valid height greater than 3 feet");
        }
    }

    public static void checkWeight(double weight){
        if(weight < 0){
            throw new IllegalArgumentException("Weight must be positive");
        }
    }

}



