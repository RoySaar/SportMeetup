package com.saar.roy.sportmeetup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    MockBackEnd backEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backEnd = new MockBackEnd();
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView usernameInput = (TextView)findViewById(R.id.usernameInput);
        TextView passwordInput = (TextView)findViewById(R.id.passwordInput);
        String username = usernameInput.getText().toString();
        String password  = passwordInput.getText().toString();
        if (backEnd.signIn(username, password)) {
            Intent intent = new Intent(this,DashboardActivity.class);
            startActivity(intent);
        }
        else
        Toast.makeText(this,"Wrong Username/Password",Toast.LENGTH_SHORT).show();
    }

    class MockBackEnd implements BackEnd {

        @Override
        public boolean signUp(String username, String password) {
            return false;
        }

        @Override
        public boolean signIn(String username, String password) {
            return username.equals("admin") && password.equals("password");
        }

        @Override
        public void saveMatch(Match match) {

        }

        @Override
        public void saveUser(User user) {

        }

        @Override
        public User getUserByUsername(String username) {
            return null;
        }

        @Override
        public void getMatchesByUser(User user) {

        }

    }
}

