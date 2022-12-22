package com.example.SignDecoder;

import static com.example.SignDecoder.Quiz.qlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.Collections;
import java.util.List;

public class qna extends AppCompatActivity {
    CountDownTimer countDownTimer;
    TextView optext1;
    TextView optext2;
    TextView optext3;
    ImageView question;
    MaterialCardView opcard1, opcard2, opcard3;
    List<qnaSetter> Questions;
    qnaSetter qnaSetter;
    int timerval = 20;
    int index = 0;
    public static  String answer;
    RoundedHorizontalProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qna);
        getSupportActionBar().hide();
        getId();
        question = findViewById(R.id.questionimg);
        progressBar = findViewById(R.id.timer);
        Questions = qlist;
        Collections.shuffle(Questions);
        qnaSetter = qlist.get(index);
        setQuestion();
        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                timerval = timerval - 1;
                progressBar.setProgress(timerval);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(qna.this);
                dialog.setContentView(R.layout.timeout2);
                //dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.show();
            }
        }.start();
    }

    public void getId() {
        optext1 = findViewById(R.id.opt1);
        optext2 = findViewById(R.id.opt2);
        optext3 = findViewById(R.id.opt3);
        opcard1 = findViewById(R.id.option1);
        opcard1 = findViewById(R.id.option2);
        opcard1 = findViewById(R.id.option3);
    }

    public void setQuestion() {
        optext1.setText(qnaSetter.getOpt1());
        optext2.setText(qnaSetter.getOp2());
        optext3.setText(qnaSetter.getOp3());
        answer = qnaSetter.getAnswer();
       // answer = "a";
        int id = this.getResources().getIdentifier("@drawable/" + answer, null, getPackageName());
        question.setImageResource(id);

    }
}