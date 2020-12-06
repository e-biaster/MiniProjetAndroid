package com.esprit.miniproject.bottomnav;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.esprit.miniproject.DashboardActivity;
import com.esprit.miniproject.LoginActivity;
import com.esprit.miniproject.R;
import com.esprit.miniproject.WelcomeActivity;
import com.esprit.miniproject.session.SQLiteHandler;
import com.esprit.miniproject.session.SessionManager;

import java.util.HashMap;

public class NavDashboardFragment extends Fragment {

    private SQLiteHandler db;
    private SessionManager session;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = (ViewGroup) inflater.inflate(R.layout.fragment_nav_dashboard, container, false);
        TextView txtName = (TextView) root.findViewById(R.id.name);
        TextView txtEmail = (TextView) root.findViewById(R.id.email);
        Button btnLogout = (Button) root.findViewById(R.id.btnLogout);

        db = new SQLiteHandler(getActivity().getApplicationContext());
        session = new SessionManager(getActivity().getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");
        txtName.setText(name);
        txtEmail.setText(email);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

        return root;
    }

    private void logoutUser() {
        session.setLogin(false);
        db.deleteUsers();
        Intent i = new Intent(getActivity(), LoginActivity.class);
        startActivity(i);
        getActivity().finish();
    }

}
