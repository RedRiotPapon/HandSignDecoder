package com.example.SignDecoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://learnoset-b568d-default-rtdb.firebaseio.com/");

    CardView cardView;
    CardView cardView2;
    CardView cardView3;
public static ArrayList<qnaSetter>qlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        cardView = findViewById(R.id.level1);
        cardView2 = findViewById(R.id.level2);
        cardView3 = findViewById(R.id.level3);
        qlist = new ArrayList<>();


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            
        qlist.add(new qnaSetter("a","b","c","a"));
        qlist.add(new qnaSetter("h","e","f","f"));
        qlist.add(new qnaSetter("i","j","k","i"));
        qlist.add(new qnaSetter("b","x","z","z"));
        qlist.add(new qnaSetter("c","o","p","o"));
            
                Intent intent = new Intent(Quiz.this,qna.class);
                startActivity(intent);
            }
        });


        Intent i = getIntent();
        String str = i.getStringExtra("sms");
//        TextView obj = findViewById(R.id.lvl);
//        obj.setText(str);


        



        if(str.equals("1"))
        {
            cardView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
        qlist.add(new qnaSetter("dog","jug","pet","dog"));
        qlist.add(new qnaSetter("mse","cse","ece","cse"));
        qlist.add(new qnaSetter("rat","act","ant","ant"));
        qlist.add(new qnaSetter("joy","ace","toy","joy"));
        qlist.add(new qnaSetter("sir","car","bar","sir"));
                
                
                    Intent intent = new Intent(Quiz.this,qna.class);
                    startActivity(intent);
                }
            });
        }





        if(str.equals("2"))
        {
            cardView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                       
        qlist.add(new qnaSetter("kuet","ruet","buet","kuet"));
        qlist.add(new qnaSetter("move","love","dove","love"));
        qlist.add(new qnaSetter("cgpa","back","base","cgpa"));
        qlist.add(new qnaSetter("best","rest","test","best"));
        qlist.add(new qnaSetter("busy","life","type","life"));
                
                
                    Intent intent = new Intent(Quiz.this,qna.class);
                    startActivity(intent);
                }
            });
        }



    }

}