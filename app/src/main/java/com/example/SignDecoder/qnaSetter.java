package com.example.SignDecoder;

import android.widget.ImageView;

public class qnaSetter {
    private String opt1;
    private String op2;

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String op3;
    private String answer;
    public qnaSetter(String opt1, String op2, String op3, String answer) {
        this.opt1 = opt1;
        this.op2 = op2;
        this.op3 = op3;
        this.answer = answer;
    }



}
