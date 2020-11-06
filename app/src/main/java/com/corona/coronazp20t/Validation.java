package com.corona.coronazp20t;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String USERNAME_REGEX_PATTERN="^[A-Za-z]{3,20}$";
    public static final String PASSWORD_REGEX_PATTERN="^[A-Za-z0-9(.!@_)]{5,20}$";
    public static final String EMAIL_REGEX_PATTERN="^[A-Za-z0-9(@._-)]{10,50}";

    public static boolean isValidUsername(String username){
        Pattern pattern=Pattern.compile(USERNAME_REGEX_PATTERN);//Kuriamas sablonas pagal musu stringa
        Matcher matcher=pattern.matcher(username);//Palyginamas sablonas su vartotojo ivestais duomenimis

        return matcher.find();//Grazina true jeigu atitinka, false priesingu atveju
    }
    public static  boolean isValidPassword(String password){
        Pattern pattern=Pattern.compile(PASSWORD_REGEX_PATTERN);
        Matcher matcher=pattern.matcher(password);

        return matcher.find();
    }
    public static boolean isValidEmail(String email){
        Pattern pattern=Pattern.compile(EMAIL_REGEX_PATTERN);
        Matcher matcher=pattern.matcher(email);

        return matcher.find();
    }
}
