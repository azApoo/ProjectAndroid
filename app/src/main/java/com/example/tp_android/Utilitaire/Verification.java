package com.example.tp_android.Utilitaire;

import com.example.tp_android.Models.ListUser;
import com.example.tp_android.Models.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification {
    private static final String USERNAME_PATTERN = "^[A-Za-z0-9]{1,}$";
    public static final String PW_PATTERN = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W_]+$)(?![A-Za-z\\W_]+$)(?![A-Z0-9\\W_]+$)[a-zA-Z0-9\\W_]{8,}$";

    public static boolean validerUsername(String username){
        return username.matches(USERNAME_PATTERN);
    }

    public static boolean validerPassword(String password){

        return password.matches(PW_PATTERN);
    }

    public static boolean verifierUserPwd(String inputUser, String inputPassword){
        List<User> listUser=ListUser.getListUser();
        for(User u: listUser){
            if(u.getUsername().equals(inputUser) && u.getPassword().equals(inputPassword))
                return true;
        }
        return false;
    }

}
