package com.saar.roy.sportmeetup;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button signInButton;
    TextView signUpButton;
    MockBackEnd backEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        backEnd = new MockBackEnd();
        signInButton = (Button)findViewById(R.id.signInButton);
        signInButton.setOnClickListener(this);
        signUpButton = (TextView)findViewById(R.id.signInText);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == signInButton) {
            TextView usernameInput = (TextView) findViewById(R.id.usernameInput);
            TextView passwordInput = (TextView) findViewById(R.id.passwordInput);
            String username = usernameInput.getText().toString();
            String password = passwordInput.getText().toString();
            if (backEnd.signIn(username, password)) {
                Intent intent = new Intent(this, DashboardActivity.class);
                startActivity(intent);
            } else
                Toast.makeText(this, "Wrong Username/Password", Toast.LENGTH_SHORT).show();
        }
        else if (v == signUpButton) {
            Dialog signUpDialog = new Dialog(this);
            signUpDialog.setTitle("Sign Up");
            signUpDialog.setContentView(R.layout.dialog_signIn);
            Button submitButton = (Button)signUpDialog.findViewById(R.id.registerSubmit);
            signUpDialog.show();
        }
    }

    class MockBackEnd implements BackEnd {

        @Override
        public boolean signUp(String username, String password) {
            return false;
        }

        @Override
        public boolean signIn(String username, String password) {
            return username.equals("A") && password.equals("a");
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

