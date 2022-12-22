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
        qlist.add(new qnaSetter("A","B","C","a"));
        qlist.add(new qnaSetter("H","E","F","f"));
        qlist.add(new qnaSetter("I","J","K","i"));
        qlist.add(new qnaSetter("B","X","Z","z"));
        qlist.add(new qnaSetter("C","O","P","o"));
        qlist.add(new qnaSetter("A","B","C","a"));
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Quiz.this,qna.class);
                startActivity(intent);
            }
        });
    }
}