package com.example.SignDecoder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends Fragment {
    static {
        if(OpenCVLoader.initDebug()){
            Log.d("MainActivity: ","Opencv is loaded");
        }
        else {
            Log.d("MainActivity: ","Opencv failed to load");
        }
    }


    private Button camera_button;
    private Button bgbtn1;
    private Button bgbtn2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_main, container, false);

        camera_button=view.findViewById(R.id.camera_button);
        bgbtn1=view.findViewById(R.id.bgbtn);
        bgbtn2=view.findViewById(R.id.bgbtn2);
        ObjectAnimator scaleDown = ObjectAnimator.ofPropertyValuesHolder(
                bgbtn1,
                PropertyValuesHolder.ofFloat("scaleX", 1.25f),
                PropertyValuesHolder.ofFloat("scaleY", 1.25f));
        scaleDown.setDuration(310);
        scaleDown.setInterpolator(new FastOutSlowInInterpolator());
        scaleDown.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown.setRepeatMode(ObjectAnimator.REVERSE);

        ObjectAnimator scaleDown1 = ObjectAnimator.ofPropertyValuesHolder(
                bgbtn2,
                PropertyValuesHolder.ofFloat("scaleX", 1.5f),
                PropertyValuesHolder.ofFloat("scaleY", 1.5f));
        scaleDown1.setDuration(310);
        scaleDown1.setInterpolator(new FastOutSlowInInterpolator());
        scaleDown1.setRepeatCount(ObjectAnimator.INFINITE);
        scaleDown1.setRepeatMode(ObjectAnimator.REVERSE);
        scaleDown1.start();
        scaleDown.start();
        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),CameraActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });




        return view;
    }

}