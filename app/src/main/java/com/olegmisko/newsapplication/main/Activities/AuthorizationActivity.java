package com.olegmisko.newsapplication.main.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.olegmisko.newsapplication.R;

public class AuthorizationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Authorization");
        checkLoginState();
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button signUpButton = (Button) findViewById(R.id.signup_button);
        loginButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                Intent loadLogin = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loadLogin);
                overridePendingTransition(R.anim.alpha, R.anim.alpha_out);
                break;
            case R.id.signup_button:
                Intent loadRegistration = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(loadRegistration);
                overridePendingTransition(R.anim.alpha, R.anim.alpha_out);
                break;
            default:
                break;
        }
    }

    private void loadApplication() {
        Intent loadMainActivity = new Intent(this, NavigationDrawerActivity.class);
        startActivity(loadMainActivity);
        overridePendingTransition(R.anim.alpha, R.anim.alpha_out);
    }

    private void checkLoginState() {
        SharedPreferences preferences = getSharedPreferences("MainPref", MODE_PRIVATE);
        if (preferences.getBoolean("Logged_in", false)) {
            loadApplication();
        }
    }
}
