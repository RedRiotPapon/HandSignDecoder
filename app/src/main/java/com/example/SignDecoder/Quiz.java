package com.example.SignDecoder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {
CardView cardView;
public static ArrayList<qnaSetter>qlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        cardView = findViewById(R.id.level1);
        qlist = new ArrayList<>();
        qlist.add(new qnaSetter("a","b","c","a"));
        qlist.add(new qnaSetter("h","e","f","f"));
        qlist.add(new qnaSetter("i","j","k","i"));
        qlist.add(new qnaSetter("b","x","z","z"));
        qlist.add(new qnaSetter("c","o","p","o"));
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quiz.this,qna.class);
                startActivity(intent);
            }
        });
    }
}