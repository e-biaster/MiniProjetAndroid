package com.esprit.miniproject.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.esprit.miniproject.DashboardActivity;
import com.esprit.miniproject.R;
import com.esprit.miniproject.session.SessionManager;

public class SplashActivity extends AppCompatActivity {

    ImageView applogo, appname, appsplash;
    LottieAnimationView lottieAnimationView;
    SessionManager session;

    private static final int NUM_PAGES=3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;

    Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        session = new SessionManager(getApplicationContext());
        if(session.isLoggedIn()){
            Intent i = new Intent(SplashActivity.this, DashboardActivity.class);
            startActivity(i);
            finish();
        }

        applogo = findViewById(R.id.applogo);
        appname = findViewById(R.id.appname);
        appsplash = findViewById(R.id.appsplash);
        lottieAnimationView = findViewById(R.id.lottie);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        anim = AnimationUtils.loadAnimation(this, R.anim.o_b_anim);
        viewPager.startAnimation(anim);

        appsplash.animate().translationY(-3000).setDuration(1000).setStartDelay(4000);
        applogo.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        appname.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                OnBoardingFragment1 tab1 = new OnBoardingFragment1();
                return tab1;
                case 1: OnBoardingFragment2 tab2 = new OnBoardingFragment2();
                return tab2;
                case 2: OnBoardingFragment3 tab3 = new OnBoardingFragment3();
                return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}