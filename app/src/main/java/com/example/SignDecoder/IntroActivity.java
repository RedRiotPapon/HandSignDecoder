package com.example.SignDecoder;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;

import io.github.dreierf.materialintroscreen.MaterialIntroActivity;
import io.github.dreierf.materialintroscreen.SlideFragmentBuilder;

public class IntroActivity extends MaterialIntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.reddish)
                .buttonsColor(R.color.grey_font)
                .image(R.drawable.onboard)
                .title("Welcome")
                .description("to Sign Decoder")
                .build());
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.blueish)
                .buttonsColor(R.color.grey_font)
                .image(R.drawable.onbrd2)
                .title("title2")
                .description("Desc2")
                .build());
        addSlide(new SlideFragmentBuilder()
                .backgroundColor(R.color.blueish)
                .buttonsColor(R.color.grey_font)
                .image(R.drawable.lrn)
                .title("Easy to Learn")
                .description("Learn Hand signs with ease")
                .build());


    }
}