package com.saar.roy.sportmeetup;

/**
 * Created by Eidan on 7/10/2017.
 */

class MockBackEnd implements BackEnd {

    public static final String MOCK_USERNAME = "A";
    public static final String MOCK_PASSWORD = "a";

    @Override
    public boolean signUp(String username, String password) {
        return false;
    }

    @Override
    public boolean signIn(String username, String password) {
        return username.equals(MOCK_USERNAME) && password.equals(MOCK_PASSWORD);
    }

    @Override
    public void saveMatch(Match match) {

    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User getUserByUsername(String username) {
        if (!username.equals(MOCK_USERNAME)) {
            return null;
        }
        return new User(MOCK_USERNAME,MOCK_PASSWORD);
    }

    @Override
    public void getMatchesByUser(User user) {

    }
}
