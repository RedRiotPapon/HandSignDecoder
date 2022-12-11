package com.example.SignDecoder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class homeAdapter extends PagerAdapter {
    Context context;
    ArrayList <Integer> arrayList = new ArrayList<>();
    LayoutInflater layoutInflater;

    public homeAdapter(Context context, ArrayList<Integer> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.activity_home_adapter,container,false);
        ImageView imageView = view.findViewById(R.id.img);
        TextView tetxview = view.findViewById(R.id.label);
        imageView.setImageResource(arrayList.get(position));
        switch(position) {
            case 0:
                tetxview.setText("A");
                break;
            case 1:
                tetxview.setText("B");
                break;
            case 2:
                tetxview.setText("C");
                break;
            case 3:
                tetxview.setText("D");
                break;
            case 4:
                tetxview.setText("E");
                break;
            case 5:
                tetxview.setText("F");
                break;
            case 6:
                tetxview.setText("G");
                break;
            case 7:
                tetxview.setText("H");
                break;
            case 8:
                tetxview.setText("I");
                break;
            case 9:
                tetxview.setText("J");
                break;
            case 10:
                tetxview.setText("K");
                break;
            case 11:
                tetxview.setText("L");
                break;
            case 12:
                tetxview.setText("M");
                break;
            case 13:
                tetxview.setText("N");
                break;
            case 14:
                tetxview.setText("O");
                break;
            case 15:
                tetxview.setText("P");
                break;
            case 16:
                tetxview.setText("Q");
                break;
            case 17:
                tetxview.setText("R");
                break;
            case 18:
                tetxview.setText("S");
                break;
            case 19:
                tetxview.setText("T");
                break;
            case 20:
                tetxview.setText("U");
                break;
            case 21:
                tetxview.setText("V");
                break;
            case 22:
                tetxview.setText("W");
                break;
            case 23:
                tetxview.setText("X");
                break;
            case 24:
                tetxview.setText("Y");
                break;
            default:
                tetxview.setText("Z");
        }
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}