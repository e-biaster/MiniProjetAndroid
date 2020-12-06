package com.esprit.miniproject;

import java.util.HashMap;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.esprit.miniproject.bottomnav.NavChatFragment;
import com.esprit.miniproject.bottomnav.NavDashboardFragment;
import com.esprit.miniproject.bottomnav.NavGroupFragment;
import com.esprit.miniproject.bottomnav.NavSearchFragment;
import com.esprit.miniproject.bottomnav.NavWalletFragment;
import com.esprit.miniproject.session.SQLiteHandler;
import com.esprit.miniproject.session.SessionManager;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class DashboardActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.bottom_nav_dashboard, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NavDashboardFragment()).commit();
        bottom_menu();
    }

    private void bottom_menu() {

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch(i){
                    case R.id.bottom_nav_dashboard:
                        fragment = new NavDashboardFragment();
                        break;
                    case R.id.bottom_nav_search:
                        fragment = new NavSearchFragment();
                        break;
                    case R.id.bottom_nav_wallet:
                        fragment = new NavWalletFragment();
                        break;
                    case R.id.bottom_nav_chat:
                        fragment = new NavChatFragment();
                        break;
                    case R.id.bottom_nav_group:
                        fragment = new NavGroupFragment();
                        break;
                }

             getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();

            }
        });

    }
}