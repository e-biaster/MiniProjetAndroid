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

public class SignupTabFragment extends Fragment {
    View view;
    EditText mail, password, passx;
    Button btnsign;
    float v=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.signup_tab_fragment, container, false);

        mail = view.findViewById(R.id.mail);
        password = view.findViewById(R.id.password);
        passx = view.findViewById(R.id.passx);
        btnsign = view.findViewById(R.id.btnsign);

        mail.setTranslationY(800);
        password.setTranslationY(800);
        passx.setTranslationY(800);
        btnsign.setTranslationY(800);

        mail.setAlpha(v);
        password.setAlpha(v);
        passx.setAlpha(v);
        btnsign.setAlpha(v);

        mail.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        passx.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        btnsign.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();

        return view;
    }
}
