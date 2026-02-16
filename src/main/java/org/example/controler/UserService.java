package org.example.controler;

import org.example.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String,User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void run() {


    }


    public void register(String useri, String passwd){

        User user1 = new User("user1", "123456789");
        users.put(user1)

    }

}
