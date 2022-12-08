package com.example.SignDecoder;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class frag2 extends Fragment {

    private Button combine_letter_button;
    private Button bgbtn1;
    private Button bgbtn2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        combine_letter_button=view.findViewById(R.id.combine_letter_button);
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
        combine_letter_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getActivity(),CombineLettersActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}