package com.example.SignDecoder;

import static com.example.SignDecoder.Quiz.qlist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    ImageView imageView;
    List<qnaSetter> Questions;
    qnaSetter qnaSetter;
    int timerval = 20;
    int index = 0;
    int correctcnt = 0;
    int incorrectcnt = 0;
    LinearLayout btnnext ;

    public static  String answer;
    RoundedHorizontalProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qna);
        getSupportActionBar().hide();
        getId();

        Questions = qlist;
        Collections.shuffle(Questions);
        qnaSetter = qlist.get(index);
        setQuestion();
        imageView = findViewById(R.id.exit);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(qna.this, Quiz.class);
                startActivity(intent);
            }
        });
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
    public void correctAns(TextView optext1){
        optext1.setBackgroundResource(R.color.greenish);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctcnt++;
                if (index < qlist.size() - 1) {
                    index++;
                    qnaSetter = qlist.get(index);
                    setQuestion();
                    resetcolor();
                    enableButton();
                }
                else {
                    levelComplete();
                }
            }
        });

    }
    public void incorrectAns(TextView optext1) {

        optext1.setBackgroundResource(R.color.reddish);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                incorrectcnt++;
                if (index < qlist.size() - 1) {
                    index++;
                    qnaSetter = qlist.get(index);
                    setQuestion();
                    resetcolor();
                    enableButton();
                }
                else {
                    levelComplete();
                }
            }
        });

        }
    public void getId() {
        question = findViewById(R.id.questionimg);
        progressBar = findViewById(R.id.timer);
        optext1 = findViewById(R.id.opt1);
        optext2 = findViewById(R.id.opt2);
        optext3 = findViewById(R.id.opt3);
        opcard1 = findViewById(R.id.option1);
        opcard1 = findViewById(R.id.option2);
        opcard1 = findViewById(R.id.option3);
        btnnext = findViewById(R.id.nxt);
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
    public void enableButton()

    {
        optext1.setClickable(true);
        optext2.setClickable(true);
        optext3.setClickable(true);
    }
    public void disableButton () {
        optext1.setClickable(false);
        optext2.setClickable(false);
        optext3.setClickable(false);
    }
    public void resetcolor() {
        optext1.setBackgroundResource(R.color.white);
        optext2.setBackgroundResource(R.color.white);
        optext3.setBackgroundResource(R.color.white);

    }
    //option1 action
    public void opton1Click(View view)
    {  disableButton ();
        if (qnaSetter.getOpt1().equals(qnaSetter.getAnswer()))
        {
            optext1.setBackgroundColor(getResources().getColor(R.color.greenish));

            if (index <= qlist.size() - 1) {
//                    index++;
//                    qnaSetter = qlist.get(index);
//                    getId();
//                    resetcolor();
                    correctAns(optext1);

            }
                else{
                    levelComplete();

                }

        }
        else{

            incorrectAns(optext1);
        }

        }
    //option3 action
    public void opton3Click(View view)
    { disableButton ();
        if (qnaSetter.getOp3().equals(qnaSetter.getAnswer()))
        {
            optext3.setBackgroundColor(getResources().getColor(R.color.greenish));

            if (index <= qlist.size() - 1) {
//                    index++;
//                    qnaSetter = qlist.get(index);
//                    getId();
//                    resetcolor();
                correctAns(optext3);

            }
            else{
                levelComplete();

            }

        }
        else{

            incorrectAns(optext3);
        }

    }
    //option2 action
    public void opton2Click(View view)
    {    disableButton ();
        if (qnaSetter.getOp2().equals(qnaSetter.getAnswer()))
        {
            optext2.setBackgroundColor(getResources().getColor(R.color.greenish));

            if (index <= qlist.size() - 1) {
//                    index++;
//                    qnaSetter = qlist.get(index);
//                    getId();
//                    resetcolor();
                correctAns(optext2);

            }
            else{
                levelComplete();

            }

        }
        else{

            incorrectAns(optext2);
        }

    }


        public void levelComplete(){

Intent intent = new Intent(this,finalPage.class);
intent.putExtra("correct",correctcnt);
intent.putExtra("incorrect",incorrectcnt);
startActivity(intent);

    }
}