package com.example.SignDecoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class home extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
   // home homeFragment = new home();
    MainActivity signtoletter = new MainActivity();
    frag1 homeFragment = new frag1();
    frag2 signtoword = new frag2();
    frag3 signtospeech = new frag3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView  = findViewById(R.id.bottomNavbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,homeFragment).commit();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,homeFragment).commit();
                        return true;
                    case R.id.letter:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,signtoletter).commit();
                        return true;
                    case R.id.word:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,signtoword).commit();
                        return true;
                    case R.id.voice:
                        getSupportFragmentManager().beginTransaction().replace(R.id.FragmentContainer,signtospeech).commit();
                        return true;
                }

                return false;
            }
        });



    }
}