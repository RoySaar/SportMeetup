package com.saar.roy.sportmeetup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roy-PC on 08-Jul-17.
 */
public class User {
    private String password;
    private final String username;
    private final List<User> friends;

    public User(String password, String username) {
        this.password = password;
        this.username = username;
        friends = new ArrayList<>();
    }


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
