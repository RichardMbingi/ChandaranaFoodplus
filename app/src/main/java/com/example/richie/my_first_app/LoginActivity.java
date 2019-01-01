package com.example.richie.my_first_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView noOfAttempts;
    private Button loginButton;
    private int passwordTrialCounter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        loginButton = findViewById(R.id.loginButton);
        noOfAttempts = findViewById(R.id.noOfAttempts);

        noOfAttempts.setText("No. of attempts:5");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateUser(Username.getText().toString(),Password.getText().toString());
            }
        });
    }

    private void ValidateUser (String Username, String Password){
        if ((!Password.equals("1234")) || (!Username.equals("Richie"))) {
            passwordTrialCounter--;
            noOfAttempts.setText(String.format("No. of attempts:" + String.valueOf(passwordTrialCounter)));
            if (passwordTrialCounter == 0) loginButton.setEnabled(false);
        } else {
            Intent loggingIn = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(loggingIn);
        }
    }
}
