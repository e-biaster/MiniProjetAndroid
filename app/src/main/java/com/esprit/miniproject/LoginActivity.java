package com.esprit.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton fb,google,twt;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        fb = findViewById(R.id.fab_facebook);
        google = findViewById(R.id.fab_google);
        twt = findViewById(R.id.fab_twitter);

        LoginAdapter adapter = new LoginAdapter((getSupportFragmentManager()));
        adapter.AddFragment(new LoginTabFragment(), "Login");
        adapter.AddFragment(new SignupTabFragment(), "Signup");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        fb.setTranslationY(300);
        google.setTranslationY(300);
        twt.setTranslationY(300);
        tabLayout.setTranslationY(300);

        fb.setAlpha(v);
        google.setAlpha(v);
        twt.setAlpha(v);
        tabLayout.setAlpha(v);

        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        twt.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        

    }
}