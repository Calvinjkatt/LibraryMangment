package project;

import java.util.Scanner;

public class UserFactory {
    public UserFactory() {
    }

    public User getUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your email:");
        String email = scanner.nextLine();
        boolean passwordValid = false;

        String password;
        do {
            System.out.println("Please enter your password:");
            password = scanner.nextLine();
            if (!this.strongPasswordCheck(password)) {
                System.out.println("Your password does not meet the strength requirements. Please try again.");
            } else {
                passwordValid = true;
            }
        } while(!passwordValid);

        System.out.println("Please enter your account type:");
        System.out.println("Options: FACULTY_MEMBER, STUDENT, or NON_FACULTY_MEMBER");
        
        String userType = scanner.nextLine();
        
        if(checkIfValidUserType(userType))
        {
            if(!checkIfVisitor(userType)) //Only register user if they are not visitor
            {
                //UserManager.registerUser(this);
            }
        }
        else
        {
            do
            {
                System.out.println("Your user type was not one of the valid options.");
                System.out.println("Please enter a valid user type.");
                
                userType = scanner.nextLine(); //Use a temporary variable each time.
            }
            while(!checkIfValidUserType(userType));
            
            if(!checkIfVisitor(userType)) //Only register user if they are not visitor
            {
                //UserManager.registerUser(this);
            }
        }
        
        scanner.close();
        
        User user = null;
        if (userType.equalsIgnoreCase("FACULTY_MEMBER")) {
            user = new FacultyMember(email, password, UserType.FACULTY_MEMBER);
        } else if (userType.equalsIgnoreCase("STUDENT")) {
            user = new Student(email, password, UserType.STUDENT);
        } else if (userType.equalsIgnoreCase("NON_FACULTY_MEMBER")) {
            user = new NonFacultyMember(email, password, UserType.NON_FACULTY_MEMBER);
        }

        if (user != null && !checkIfVisitor(userType)) {
            UserManager.registerUser(user);
        }
        return user;
    }

    public boolean strongPasswordCheck(String password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        char[] var9;
        int var8 = (var9 = password.toCharArray()).length;

        for(int var7 = 0; var7 < var8; ++var7) {
            char character = var9[var7];
            if (Character.isUpperCase(character)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(character)) {
                hasLowerCase = true;
            } else if (Character.isDigit(character)) {
                hasNumber = true;
            } else {
                hasSpecial = true;
            }
        }

        if (hasUpperCase && hasLowerCase && hasNumber && hasSpecial) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public boolean checkIfValidUserType(String userType) {
        for(UserType userTypeEnum : UserType.values())
        {
            //Check to see if the given String is one of the four user types.
            if(userTypeEnum.name().equalsIgnoreCase(userType)) 
            {
                return true;
            }
        }
        
        return false;
    }

    private boolean checkIfVisitor(String userType) {
        return userType.equalsIgnoreCase("VISITOR");
    }
}
