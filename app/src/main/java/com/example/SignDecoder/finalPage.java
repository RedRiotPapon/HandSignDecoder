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
    String name;
    String str;
    TextView text1,text2;
    CircularProgressBar progressBar;
    ImageView imageView;
    int total ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        Intent i =getIntent();
       correct = getIntent().getIntExtra("correct",0);
       incorrect = getIntent().getIntExtra("incorrect",0);
        str = i.getStringExtra("sms");
        name = i.getStringExtra("name") ;
       progressBar = findViewById(R.id.circularProgressBar);
       progressBar.setProgress(correct);
       text1 = findViewById(R.id.scoreC);
        total = correct+incorrect;
       text1.setText(correct+"/"+total);

        text2 = findViewById(R.id.score2);
        text2.setText("Your Score is  "+correct);

        if(correct==total){
            HashMap<String, Object> result = new HashMap<>();

            if(str.equals("0")) { result.put("i", "1"); str = "1"; }
            else if(str.equals("1")) { result.put("i", "2"); str = "2"; }
            else if(str.equals("2")) {  str = "3"; }


            FirebaseDatabase.getInstance().getReference().child("users").child("66").updateChildren(result);
        }

        imageView = findViewById(R.id.exit);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(finalPage.this, Quiz.class);
                intent.putExtra("sms", str);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }
    @Override
    public void onBackPressed () {

    }
}