package com.example.SignDecoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://learnoset-b568d-default-rtdb.firebaseio.com/");
    TextView prgress;
    CardView cardView;
    CardView cardView2;
    CardView cardView3;
    String str;
    String name;
    ImageView tick1,tick2,tick3,lock1,lock2,lock3;
    CircularProgressBar progressBar;
    CountDownTimer countDownTimer;
public static ArrayList<qnaSetter>qlist;

public void progAnimator (float timerval)
{

    ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, 0, timerval);
    anim.setDuration(2500);
    progressBar.startAnimation(anim);

}


    public void onBackPressed () {
            Intent intent = new Intent(Quiz.this,home.class);
        intent.putExtra("sms", str);
        intent.putExtra("name", name);
        startActivity(intent);
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        progressBar = findViewById(R.id.circularProgressBar);

        prgress = findViewById(R.id.prgress);




        cardView = findViewById(R.id.level1);
        cardView2 = findViewById(R.id.level2);
        tick1 = findViewById(R.id.tick1);
        tick2 = findViewById(R.id.tick2);
        tick3 = findViewById(R.id.tick3);
        lock1 = findViewById(R.id.lock1);
        lock2 = findViewById(R.id.lock2);
        lock3 = findViewById(R.id.lock3);
        cardView3 = findViewById(R.id.level3);
        qlist = new ArrayList<>();
        Intent i = getIntent();
         str = i.getStringExtra("sms");
         name = i.getStringExtra("name") ;
        switch (str) {
            case "0":
//                progressBar.setProgress(0);
              prgress.setText("0 %");
progAnimator(0);

                tick1.setImageResource(R.drawable.cross);
                tick2.setImageResource(R.drawable.cross);
                tick3.setImageResource(R.drawable.cross);
                lock2.setImageResource(R.drawable.lock);
                lock3.setImageResource(R.drawable.lock);
                break;
            case "1":
                progAnimator(33);
                prgress.setText("33 %");
                tick1.setImageResource(R.drawable.tick);
                tick2.setImageResource(R.drawable.cross);
                tick3.setImageResource(R.drawable.cross);
                lock2.setImageResource(R.drawable.unlockpadlock);
                lock3.setImageResource(R.drawable.lock);

                break;
            case "2":
                progAnimator(67);
                progressBar.setProgress(67);
                prgress.setText("67 %");
                tick1.setImageResource(R.drawable.tick);
                tick2.setImageResource(R.drawable.tick);
                tick3.setImageResource(R.drawable.cross);
                lock2.setImageResource(R.drawable.unlockpadlock);
                lock3.setImageResource(R.drawable.unlockpadlock);
                break;
            case "3":
                progAnimator(100);
                prgress.setText("100%");
                tick1.setImageResource(R.drawable.tick);
                tick2.setImageResource(R.drawable.tick);
                tick3.setImageResource(R.drawable.tick);

                lock1.setImageResource(R.drawable.unlockpadlock);
                lock2.setImageResource(R.drawable.unlockpadlock);
                lock3.setImageResource(R.drawable.unlockpadlock);
                break;
            default:
                progAnimator(100);
                prgress.setText("100%");
                tick1.setImageResource(R.drawable.tick);
                tick2.setImageResource(R.drawable.tick);
                tick3.setImageResource(R.drawable.tick);
                break;
        }

//        countDownTimer = new CountDownTimer(8000, 1000) {
//            @Override
//            public void onTick(long l) {
//                timerval = timerval + 1;
//                progressBar.setProgress(timerval);
//            }
//
//            @Override
//            public void onFinish() {
//                //  Dialog dialog = new Dialog(qna.this);
//                //dialog.setContentView(R.layout.timeout2);
//                //dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
//                //dialog.show();
//            }
//        }.start();

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            
        qlist.add(new qnaSetter("a","b","c","a"));
        qlist.add(new qnaSetter("h","e","f","f"));
        qlist.add(new qnaSetter("i","j","k","i"));
        qlist.add(new qnaSetter("b","x","z","z"));
        qlist.add(new qnaSetter("c","o","p","o"));
            
                Intent intent = new Intent(Quiz.this,qna.class);
                intent.putExtra("sms", str);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });



      //TextView obj = findViewById(R.id.lvl);
       //obj.setText(str);


        



        if(str.equals("1") || str.equals("2") || str.equals("3"))
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
                    intent.putExtra("sms", str);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            });
        }





        if(str.equals("2") || str.equals("3")  )
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
                    intent.putExtra("sms", str);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }
            });
        }



    }

}