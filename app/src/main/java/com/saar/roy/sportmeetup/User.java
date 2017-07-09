package com.saar.roy.sportmeetup;

import java.util.List;

/**
 * Created by Roy-PC on 08-Jul-17.
 */
public class User {
    private String password;
    private String username;
    private List<User> friends;


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public List<User> getFriends() {
        return friends;
    }

}
