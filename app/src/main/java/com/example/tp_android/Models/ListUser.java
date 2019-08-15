package com.example.tp_android.Models;

import java.util.ArrayList;
import java.util.List;

public class ListUser {
    private static final List<User> listUser = new ArrayList();

    static {
        listUser.add(new User("abcd2019", "Abcd1234;"));
        listUser.add(new User("Programmeur111", "123ABCabc_"));
        listUser.add(new User("Programmeur222", "/$456defDEF"));
        listUser.add(new User("Programmeur333", "hij?HIJ789"));
        listUser.add(new User("Programmeur555", "|#000XYZxyz"));
    }

    public static List<User> getListUser() {
        return listUser;
    }
}
