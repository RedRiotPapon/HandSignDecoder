package com.example.SignDecoder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


public class frag1 extends Fragment {

    ViewPager viewPager;
    ArrayList<Integer> arrayList= new ArrayList<>();
    Context thiscontext;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        thiscontext = container.getContext();
        button =view.findViewById(R.id.testbtn);
        arrayList.add(R.drawable.a);
        arrayList.add(R.drawable.b);
        arrayList.add(R.drawable.c);
        arrayList.add(R.drawable.d);
        arrayList.add(R.drawable.e);
        arrayList.add(R.drawable.f);
        arrayList.add(R.drawable.g);
        arrayList.add(R.drawable.h);
        arrayList.add(R.drawable.i);
        arrayList.add(R.drawable.j);
        arrayList.add(R.drawable.k);
        arrayList.add(R.drawable.l);
        arrayList.add(R.drawable.m);
        arrayList.add(R.drawable.n);
        arrayList.add(R.drawable.o);
        arrayList.add(R.drawable.p);
        arrayList.add(R.drawable.q);
        arrayList.add(R.drawable.r);
        arrayList.add(R.drawable.s);
        arrayList.add(R.drawable.t);
        arrayList.add(R.drawable.u);
        arrayList.add(R.drawable.v);
        arrayList.add(R.drawable.w);
        arrayList.add(R.drawable.x);
        arrayList.add(R.drawable.y);
        arrayList.add(R.drawable.z);

        homeAdapter homeAdapter = new homeAdapter(thiscontext,arrayList);
        viewPager.setAdapter(homeAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quiz activity = (Quiz) getActivity();
                Intent intent = new Intent(getActivity(),Quiz.class);
                startActivity(intent);
            }
        });
        return view;
    }
}