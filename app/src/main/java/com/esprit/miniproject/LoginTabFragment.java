package com.esprit.miniproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginTabFragment extends Fragment{
    View view;
    EditText email, pass;
    TextView forgetpass;
    Button btnlogin;
    float v=0;

    public LoginTabFragment (){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = view.findViewById(R.id.email);
        pass = view.findViewById(R.id.pass);
        forgetpass = view.findViewById(R.id.forgetpass);
        btnlogin = view.findViewById(R.id.btnlogin);

        email.setTranslationY(800);
        pass.setTranslationY(800);
        forgetpass.setTranslationY(800);
        btnlogin.setTranslationY(800);

        email.setAlpha(v);
        pass.setAlpha(v);
        forgetpass.setAlpha(v);
        btnlogin.setAlpha(v);

        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgetpass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        btnlogin.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return view;
    }
}
