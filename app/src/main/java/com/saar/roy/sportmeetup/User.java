package com.saar.roy.sportmeetup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roy-PC on 08-Jul-17.
 */
public class User {
    private String uid;
    private final List<String> friendUIDs;
    private String displayName;

    public User() {
        this(null);
    }

    public User(String uid) {
        this.uid = uid;
        displayName = null;
        friendUIDs = new ArrayList<>();
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getUid() {
        return uid;
    }

    public List<String> getFriendUIDs() {
        return friendUIDs;
    }
}
