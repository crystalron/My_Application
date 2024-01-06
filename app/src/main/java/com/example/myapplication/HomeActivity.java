package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {
    DBHelper DB;
    //TextView tool, progress, exercise;


    TabLayout tabLayout;
    ViewPager2 viewPager2;
    VPAdapter vpAdapter;
    ImageButton progressTracking, exerciseGuide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
        vpAdapter = new VPAdapter(this);
        viewPager2.setAdapter(vpAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
        /*tool = (TextView) findViewById(R.id.HelloUser);
        progress = (TextView)findViewById(R.id.progressView);
        exercise = (TextView)findViewById(R.id.exerciseView);
        progressTracking = (ImageButton)findViewById(R.id.progressTracking);
        exerciseGuide = (ImageButton)findViewById(R.id.exerciseGuide);*/
        String nameOfUser;




    }

}