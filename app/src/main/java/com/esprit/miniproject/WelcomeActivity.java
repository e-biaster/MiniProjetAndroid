package com.esprit.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.esprit.miniproject.session.SessionManager;

public class WelcomeActivity extends AppCompatActivity {

    Button loginbtn;
    TextView registertxt;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        session = new SessionManager(getApplicationContext());
        if(session.isLoggedIn()){
            Intent i = new Intent(WelcomeActivity.this, DashboardActivity.class);
            startActivity(i);
            finish();
        }

        loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        registertxt = findViewById(R.id.textView6);
        registertxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });

    }
}