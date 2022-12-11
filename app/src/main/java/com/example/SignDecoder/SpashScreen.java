package com.example.SignDecoder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SpashScreen extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progress;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_spash_screen);
        getSupportActionBar().hide(); //
        progressBar = (ProgressBar) findViewById(R.id.progressBarId);
        preferences = getSharedPreferences("splash",MODE_PRIVATE);
        editor  = preferences.edit();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });

        thread.start();
    }

    public void doWork() {

        for(progress=20; progress<=100; progress = progress+10) {
            try {
                Thread.sleep(500);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startApp() {
        if(preferences.getBoolean("issMain", false)){
            Intent intent = new Intent(this, home.class);
            startActivity(intent);
            finish();

        }
        else{
            editor.putBoolean("issMain",true);
            editor.apply();

            TaskStackBuilder.create(SpashScreen.this)
                    .addNextIntentWithParentStack(new Intent(this, home.class))
                    .addNextIntent(new Intent(this, IntroActivity.class))
                    .startActivities();

        }

    }

}
