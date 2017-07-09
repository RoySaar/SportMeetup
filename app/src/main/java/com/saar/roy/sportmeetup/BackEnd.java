package com.saar.roy.sportmeetup;

/**
 * Created by Roy-PC on 08-Jul-17.
 */
public interface BackEnd {
    boolean signUp(String username, String password);
    boolean signIn(String username, String password);
    void saveMatch(Match match);
    void saveUser(User user);
    User getUserByUsername(String username);
    void getMatchesByUser(User user);
}
