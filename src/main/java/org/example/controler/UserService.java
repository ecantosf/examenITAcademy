package org.example.controler;

import org.example.exceptions.IsNullException;
import org.example.exceptions.PasswordLengthException;
import org.example.exceptions.UserAlreadyExistException;
import org.example.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<String,User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void run() {
        try{
            register("Adri", "12345678");
            register("Eduard", "87654321");
            register("Adri", "87654321");
        }catch (IsNullException |  PasswordLengthException | UserAlreadyExistException e){
            System.out.println(e.getMessage());
        }

        System.out.println(users.toString());
    }


    public void register(String useri, String passwd) {

        User user1 = new User(useri, passwd);

        if(useri == null || passwd == null){
            throw new IsNullException("Error. S'ha d'introduir un usuari o una contrsenya no nula");
        }

        if(passwd.length() < 8 ){
            throw new PasswordLengthException("El tamany de la contrasenya es inferior a 8");
        }

        if(users.containsKey(useri)){
            throw new UserAlreadyExistException("L'usuari ja existeix");
        }

        users.put(user1.getUserName(), user1);
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
