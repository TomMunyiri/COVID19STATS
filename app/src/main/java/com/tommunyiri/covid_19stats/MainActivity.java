package com.tommunyiri.covid_19stats;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.transition.Slide;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.tommunyiri.covid_19stats.ui.aboutcovid19.AboutCovid19Activity;
import com.tommunyiri.covid_19stats.ui.main.SectionsPagerAdapter;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ImageView ivMenu;

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAnimation();
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        FloatingActionButton fab = findViewById(R.id.fab);
        ivMenu = findViewById(R.id.ivMenu);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsActivity();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.setVisibility(View.INVISIBLE);
    }

    public void setAnimation() {
        if (Build.VERSION.SDK_INT > 20) {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.LEFT);
            slide.setDuration(400);
            slide.setInterpolator(new DecelerateInterpolator());
            getWindow().setExitTransition(slide);
            getWindow().setEnterTransition(slide);
        }
    }

    public void settingsActivity(){
        Intent settings = new Intent(MainActivity.this, AboutAppActivity.class);
        if(Build.VERSION.SDK_INT>20){
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            startActivity(settings,options.toBundle());
        }else {
            startActivity(settings);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        /*getMenuInflater().inflate(R.menu.main, menu);
        return true;*/
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_symptoms) {
            Intent aboutCovid = new Intent(MainActivity.this, AboutCovid19Activity.class);
            aboutCovid.putExtra("symptoms",1);
            if(Build.VERSION.SDK_INT>20){
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                startActivity(aboutCovid,options.toBundle());
            }else {
                startActivity(aboutCovid);
            }
            //overridePendingTransition(R.transition.slide_left,R.transition.slide_right);
            return true;
        }else if(id==R.id.action_prevention){
            Intent aboutCovid = new Intent(MainActivity.this, AboutCovid19Activity.class);
            aboutCovid.putExtra("prevention",2);
            if(Build.VERSION.SDK_INT>20){
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                startActivity(aboutCovid,options.toBundle());
            }else {
                startActivity(aboutCovid);
            }
            return true;
        }else if(id == R.id.action_treatment){
            Intent aboutCovid = new Intent(MainActivity.this, AboutCovid19Activity.class);
            aboutCovid.putExtra("treatment",3);
            if(Build.VERSION.SDK_INT>20){
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                startActivity(aboutCovid,options.toBundle());
            }else {
                startActivity(aboutCovid);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}