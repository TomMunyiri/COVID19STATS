package com.tommunyiri.covid_19stats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class SplashScreenActivity extends AppCompatActivity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 4500;
    private LottieAnimationView animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

        animation = findViewById(R.id.animation);
        int[] anims = new int[]{R.raw.stay_safe_stay_home,R.raw.covid19,R.raw.hand_sanitizer,R.raw.keep_distance_coronavirus
        ,R.raw.social_distancing,R.raw.use_hand_sanitizer,R.raw.wash_your_hands_regularly,R.raw.wear_mask};
        Random randomGenerator = new Random();
        int r= randomGenerator.nextInt(anims.length);
        animation.setAnimation(anims[r]);
    }
}
