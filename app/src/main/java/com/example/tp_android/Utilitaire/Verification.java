package com.example.tp_android.Utilitaire;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification {
    private static final String USERNAME_PATTERN = "^[A-Za-z0-9]{1,}$";
    private static Pattern pattern;
    private static Matcher matcher;
    public static boolean validerUsername(String username){
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(username);
        System.out.println("matcher.matches():" +matcher.matches());
        return matcher.matches();
    }

    public static boolean validerPassword(String password){

        return true;
    }

}
