package com.example.SignDecoder;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class ProgressBarAnimation extends Animation {
    private CircularProgressBar progressBar;
    private float from;
    private float  to;

    public ProgressBarAnimation(CircularProgressBar progressBar, float from, float to) {
        super();
        this.progressBar = progressBar;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int) value);
    }

}