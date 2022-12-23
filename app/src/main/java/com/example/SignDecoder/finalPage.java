package com.example.SignDecoder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.HashMap;

public class finalPage extends AppCompatActivity {
    int correct;
    int incorrect;
    TextView text1,text2;
    CircularProgressBar progressBar;
    ImageView imageView;
    int total ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        Intent intent;
       correct = getIntent().getIntExtra("correct",0);
       incorrect = getIntent().getIntExtra("incorrect",0);
       progressBar = findViewById(R.id.circularProgressBar);
       progressBar.setProgress(correct);
       text1 = findViewById(R.id.scoreC);
        total = correct+incorrect;
       text1.setText(correct+"/"+total);

        text2 = findViewById(R.id.score2);
        text2.setText("Your Score is  "+correct);

        if(correct==total){
            HashMap<String, Object> result = new HashMap<>();
            result.put("i", "1");

            FirebaseDatabase.getInstance().getReference().child("users").child("66").updateChildren(result);
        }

        imageView = findViewById(R.id.exit);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(finalPage.this, Quiz.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed () {

    }
}